package cz.ivosahlik.rest;

import lombok.*;

@Data
public class HelloWorld {

	private String message;

	public HelloWorld(String message) {
		this.message = message;
	}

}
