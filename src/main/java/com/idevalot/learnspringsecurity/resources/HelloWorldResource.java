package com.idevalot.learnspringsecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

	@GetMapping("/hello-world")
	public String hellWorld() {
		return "Hello World v1";
	}

}
