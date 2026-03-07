package com.gateway_api.api_gateway;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // <--- Giúp Gateway kết nối và lấy thông tin routing từ Eureka
public class GatewayApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayApiApplication.class, args);
	}
}