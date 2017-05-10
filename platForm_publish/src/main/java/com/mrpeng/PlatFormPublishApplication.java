package com.mrpeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mrpeng.dao")
public class PlatFormPublishApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatFormPublishApplication.class, args);
	}
}
