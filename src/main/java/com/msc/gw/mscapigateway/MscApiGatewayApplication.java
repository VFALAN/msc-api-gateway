package com.msc.gw.mscapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MscApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscApiGatewayApplication.class, args);
	}

}
