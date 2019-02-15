package hm.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hm.model.Response;
import hm.model.VideoModel;
import hm.service.VideoService;

@RestController
@RequestMapping("/video")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@PostMapping
	public Response post(@RequestBody VideoModel model) throws MalformedURLException {

		Response response = new Response();

		response.setData(videoService.post(model));

		return response;

	}

	@GetMapping("/one/{id}")
	public Response getOne(@PathVariable("id") String id) {

		Response response = new Response();

		response.setData(videoService.get(id));

		return response;

	}
	
	@GetMapping("/all/{page}")
	public Response ge(@PathVariable("page") Integer page) {

		Response response = new Response();

		response.setData(videoService.findAll(page));

		return response;

	}
	
	@GetMapping("/random/{limitRecordds}")
	public Response random(@PathVariable("limitRecordds") Integer limitRecordds) {

		Response response = new Response();

		response.setData(videoService.random(limitRecordds));

		return response;

	}

}
