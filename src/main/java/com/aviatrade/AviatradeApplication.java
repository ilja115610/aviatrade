package com.aviatrade;

import com.aviatrade.controllers.Controller;
import com.aviatrade.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@SpringBootApplication
public class AviatradeApplication {

	public static void main(String[] args) {
		//new File(Controller.uploadDirectory).mkdir();
		SpringApplication.run(AviatradeApplication.class, args);


	}


}
