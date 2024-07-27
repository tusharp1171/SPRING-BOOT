package com.example.demo.procedure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class RabbitMQProceducer {
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	@Value("${rabbitmq.routing.key}")
	private String key;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProceducer.class);
	
	private RabbitTemplate rabbitTemplate;


	public RabbitMQProceducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendmessage(String message) {
		LOGGER.info(String.format("message send -> %s", message));
		rabbitTemplate.convertAndSend(exchange,key,message);
	}
	
	

	
}
