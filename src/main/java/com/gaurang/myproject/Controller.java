package com.gaurang.myproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller{
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	private final static String exchange="my-exchange";
	private final static String routingKey="my";
	private final static String messageData="from upgradsend to rabbit mq hello";
    private static final Logger log = LoggerFactory.getLogger(Controller.class);

	@PostMapping(value = "/producer")
	public MainObject producer(@RequestBody MainObject obj) {
		String messageData=obj.toString();
		
		amqpTemplate.convertAndSend(exchange, routingKey, messageData);
		System.out.println(obj);
		return obj;
	}
	    /*@Scheduled(fixedDelay = 3000L)
	    public void sendPracticalTip() {
	       // PracticalTipMessage tip = new PracticalTipMessage("Always use Immutable classes in Java", 1, false);
		     //amqpTemplate.convertAndSend(RabbitmqExampleApplication.EXCHANGE_NAME, RabbitmqExampleApplication.ROUTING_KEY, tip);
	        //log.info
	        log.info("Message sent via producer");
		    amqpTemplate.convertAndSend(exchange, routingKey, messageData);
		    
	    }*/
}
