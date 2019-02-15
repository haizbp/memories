package hm.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hm.entity.VideoEntity;
import hm.model.VideoModel;
import hm.repository.VideoRepository;

@Service
public class VideoService {

	@Value("${configuration.youtube.url.prefix}")
	private String youtubePattern;

	@Value("${configuration.youtube.url.embed}")
	private String youtubeEmbed;
	
	@Value("${configuration.youtube.url.thumbnail}")
	private String youtubeThumbnail;

	@Autowired
	private VideoRepository videoRepository;

	public VideoModel post(VideoModel model) throws MalformedURLException {
		boolean doing = false;
		String videoId = null;

		if (model.getUrl().startsWith(youtubePattern)) {
			doing = true;
			URL url = new URL(model.getUrl());
			Map<String, String> params = getQueryMap(url.getQuery().toString());
			videoId = params.get("v");
		}

		if (doing) {
			model.setUrl(String.format(youtubeEmbed, videoId));
			model.setThumbnail(String.format(youtubeThumbnail, videoId));
			model.setId(UUID.randomUUID().toString());
			VideoEntity entity = VideoEntity.toEntity(model);

			entity = videoRepository.save(entity);

			if (entity != null) {
				model = VideoModel.toModel(entity);
			} else {
				model = null;
			}
		} else {
			model = null;
		}

		return model;
	}
	
	public Map<String, Object> findAll(int page){
		Map<String, Object> response = new HashMap<>();
		
		Pageable pageable = PageRequest.of(page - 1, 10, Sort.by("createTime").descending());
		Page<VideoEntity> videoPage = videoRepository.findAll(pageable);
		
		response.put("page", page);
		response.put("totalRecords", videoPage.getTotalElements());
		response.put("totalPages", videoPage.getTotalPages());
		response.put("recordPerPage", 10);
		
		List<VideoModel> videoModels = new ArrayList<>();
		
		for (VideoEntity entity : videoPage.getContent()) {
			videoModels.add(VideoModel.toModel(entity));
		}
		
		response.put("content", videoModels);
		
		return response;
	}
	
	public List<VideoModel> random(int limitRecords){
		Map<String, Object> response = new HashMap<>();
		
		List<VideoEntity> videoPage = videoRepository.random(limitRecords);
		
		List<VideoModel> videoModels = new ArrayList<>();
		
		for (VideoEntity entity : videoPage) {
			videoModels.add(VideoModel.toModel(entity));
		}
		
		response.put("content", videoModels);
		
		return videoModels;
	}

	public VideoModel get(String id) {
		VideoModel model = null;

		VideoEntity entity = videoRepository.findOneById(id);

		if (entity != null)
			model = VideoModel.toModel(entity);

		return model;

	}

	public static Map<String, String> getQueryMap(String query) {
		String[] params = query.split("&");
		Map<String, String> map = new HashMap<>();
		for (String param : params) {
			String name = param.split("=")[0];
			String value = param.split("=")[1];
			map.put(name, value);
		}
		return map;
	}

}
