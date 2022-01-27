package com.techleads.app.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.Greeting;

@RestController
public class GreetingController {

	private AtomicInteger counter = new AtomicInteger();

	@GetMapping("/greetings1")
	public String greeting1(@RequestParam(name = "name", defaultValue = "System", required = false) String name) {
		return "Hi " + name;
	}

	@GetMapping("/greetings")
	public Greeting greeting(@RequestParam(name = "name", defaultValue = "System", required = false) String name) {

		Greeting gt = new Greeting();
		gt.setId(counter.incrementAndGet());
		gt.setContent(name);
		return gt;
	}
}
