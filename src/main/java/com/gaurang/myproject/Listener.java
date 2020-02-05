package com.gaurang.myproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {

    private static final Logger log = LoggerFactory.getLogger(Listener.class);
    private final static String myq="my-queue";
    @RabbitListener(queues = myq)
    public void consumeDefaultMessage(String message) {
    	 
        log.info("Received message, tip is: {}", message);
        
        System.out.println("message recieved from listener");
    }
}