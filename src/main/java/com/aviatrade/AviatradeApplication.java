package com.aviatrade;

import com.aviatrade.controllers.Controller;
import com.aviatrade.entity.Aircraft;
import com.aviatrade.entity.User;
import com.aviatrade.service.AircraftService;
import com.aviatrade.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@SpringBootApplication
public class AviatradeApplication {

	public static void main(String[] args) {
		//new File(Controller.uploadDirectory).mkdir();


		//AircraftService as = new AircraftService();
		ConfigurableApplicationContext context = SpringApplication.run(AviatradeApplication.class, args);



	}


}
