package com.es.mlutzdev.invitado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class InvitadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvitadoApplication.class, args);
	}

}
