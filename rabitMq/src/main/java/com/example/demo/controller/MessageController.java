package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.procedure.RabbitMQProceducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

	public RabbitMQProceducer proceducer;

	public MessageController(RabbitMQProceducer proceducer) {
		super();
		this.proceducer = proceducer;
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> sendmessage(@RequestParam("message") String message){
		proceducer.sendmessage(message);
		return ResponseEntity.ok("message sent to rabbitMQ ..... ");
		
		
		
	}
	
}
