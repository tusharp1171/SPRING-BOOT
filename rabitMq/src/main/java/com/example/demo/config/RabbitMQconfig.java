package com.example.demo.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.impl.AMQBasicProperties;

import lombok.val;

@Configuration
public class RabbitMQconfig {
	
	 @Value("${rabbitmq.exchange.name}")
	    private String exchange;
	    
	    @Value("${rabbitmq.queue.name}")
	    private String queue;
	    
	    @Value("${rabbitmq.routing.key}")
	    private String key;

	    @Value("${rabbitmq.routing.json.key}")
	    private String key_json;
	    
	    @Value("${rabbitmq.routing.json.name}")
	    private String name_json;
	    
	    @Bean
	    public Queue queue() {
	        return new Queue(queue);
	    }
	    @Bean
	    public Queue josnqueue() {
	    	return new Queue(name_json);
	    }

	    @Bean
	    public TopicExchange exchange() {
	        return new TopicExchange(exchange);
	    }

	    
	    @Bean
	    public Binding binding() {
	        return BindingBuilder.bind(queue()).to(exchange()).with(key);
	    }
	    @Bean
	    public Binding jsonBinding() {
	    	return BindingBuilder
	    			.bind(josnqueue())
	    			.to(exchange())
	    			.with(key_json);
	    }
	    
	    @Bean
	    public MessageConverter converter() {
	    	return new Jackson2JsonMessageConverter();	
	    }
	    
	    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
	    	RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	    	rabbitTemplate.setMessageConverter(converter());
	    	return rabbitTemplate;
	    }
}


