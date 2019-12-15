package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulEdgeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulEdgeServerApplication.class, args);
	}

}

