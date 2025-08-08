package com.lukas.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lukas.app.mapper")
public class DigitalVideoRentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalVideoRentalApplication.class, args);
	}

}
