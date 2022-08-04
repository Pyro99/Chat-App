package com.chat_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class Config implements WebSocketMessageBrokerConfigurer {
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry)
	{
		//configuring the server
		//connectivity url -> /server1
		registry.addEndpoint("/server1").withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry)
	{
		//enabled simple broker using /topic url..it's  a destination prefix
		registry.enableSimpleBroker("/topic");
		
		// /app/message -->client will send message on this url
		registry.setApplicationDestinationPrefixes("/app");
	}
	

}
