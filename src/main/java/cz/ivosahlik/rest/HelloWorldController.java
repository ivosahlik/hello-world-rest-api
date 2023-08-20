package cz.ivosahlik.rest;

import cz.ivosahlik.rest.environment.InstanceInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloWorldController {

	private final InstanceInformationService service;

	@GetMapping(path = "/")
	public String imUpAndRunning() {
		return "{healthy:true}";
	}

	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World " + " V3 " + service.retrieveInstanceInfo();
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("Hello World");
	}

	/// hello-world/path-variable/test
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorld helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld(String.format("Hello World, %s", name));
	}
}
