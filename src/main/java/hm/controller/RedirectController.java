package hm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hm.service.VideoService;

@Controller
@RequestMapping("/")
public class RedirectController {

	@Autowired
	private VideoService videoService;
	
	@GetMapping
	public String home() {
		return "home";
	}

	@GetMapping("/post")
	public String post() {
		return "post";
	}
	
	@GetMapping("/tags")
	public String tags() {
		return "tags";
	}
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("model", videoService.get(id));
		
		return "view";
	}

}
