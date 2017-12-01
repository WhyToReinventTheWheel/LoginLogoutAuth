package com.mk.webApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping("/before")
	public String before() {
		return "before!";
	}
	
	@RequestMapping("/after")
	public String after() {
		return "after!";
	}
	
	@RequestMapping("/around")
	public String around() {
		return "around!";
	}
}
