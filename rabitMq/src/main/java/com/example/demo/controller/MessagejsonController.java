package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;
import com.example.demo.procedure.RabbitMQJsonProducer;
import com.example.demo.procedure.RabbitMQProceducer;

@RestController
@RequestMapping("/api/v1")
public class MessagejsonController {

	
	private RabbitMQJsonProducer jsonProducer;

	
	
	public MessagejsonController(RabbitMQJsonProducer jsonProducer) {
		super();
		this.jsonProducer = jsonProducer;
	}






	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonmessage(@RequestBody User user){
		jsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("json message sent to RabbitMq.......");
	}
}
