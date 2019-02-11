package hm.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RedirectController {

	@GetMapping
	public String home() {
		return "home";
	}

	@GetMapping("/tags")
	public String tags() {
		return "tags";
	}
	
	@GetMapping("/view/{id}")
	public String view(@PathParam("id") String id) {
		return "view";
	}

}
