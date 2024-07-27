package com.example.demo.procedure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.User;

@Service
public class RabbitMQJsonProducer {
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	@Value("${rabbitmq.routing.json.key}")
	private String routingjsonkey;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQProceducer.class);
	
	private RabbitTemplate rabbitTemplate;

	public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	
	public void sendJsonMessage(User user) {
		LOGGER.info(String.format("json message sent -> %s", user.toString()));
		rabbitTemplate.convertAndSend(exchange,routingjsonkey,user);
	}
	

}
