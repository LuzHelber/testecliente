package br.com.helber.testecliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories
public class TesteclienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteclienteApplication.class, args);
	}

}
