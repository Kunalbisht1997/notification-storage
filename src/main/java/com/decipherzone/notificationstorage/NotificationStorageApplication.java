package com.decipherzone.notificationstorage;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NotificationStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationStorageApplication.class, args);
	}
//	@Bean
//	public ModelMapper modelMapper(){
//		return new ModelMapper();
//	}

}
