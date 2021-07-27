package com;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqTutApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqTutApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		SimpleMessage m1 = new SimpleMessage("FirstMessage1", "simpleDescription1");

		rabbitTemplate.convertAndSend(
				"TestExchangeOctavian",
				"TestRoutingOctavian",
				m1);
	}
}
