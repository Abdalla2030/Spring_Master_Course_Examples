package com.eazyschool.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class EazyschoolApplication {

	public static void main(String[] args) {

		SpringApplication.run(EazyschoolApplication.class, args);
	}

}
