package hm.model;

import java.sql.Timestamp;

import hm.entity.VideoEntity;

public class VideoModel {

	private String id;
	private String title;
	private String thumbnail;
	private String description;
	private String url;
	private Integer view;
	private Integer rate;
	private Timestamp createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		if (view == null)
			view = 0;
		this.view = view;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		if (rate == null)
			rate = 0;
		this.rate = rate;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public static VideoModel toModel(VideoEntity entity) {
		VideoModel model = new VideoModel();

		model.setId(entity.getId());
		model.setTitle(entity.getTitle());
		model.setDescription(entity.getDescription());
		model.setUrl(entity.getUrl());
		model.setView(entity.getView());
		model.setRate(entity.getRate());
		model.setCreateTime(entity.getCreateTime());
		model.setThumbnail(entity.getThumbnail());
		
		return model;
	}
}
