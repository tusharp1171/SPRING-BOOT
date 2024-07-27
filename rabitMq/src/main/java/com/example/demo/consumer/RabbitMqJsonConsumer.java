package com.example.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.demo.dto.User;

@Service
public class RabbitMqJsonConsumer {

	
	private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQConsumer.class);
	
	@RabbitListener(queues = "${rabbitmq.routing.json.name}")
	public void consumeJsonMessge(User user) {
		LOGGER.info(String.format("received json message -> %s", user.toString()));
		
	}
}
