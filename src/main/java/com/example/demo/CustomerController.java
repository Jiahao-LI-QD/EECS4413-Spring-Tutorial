package com.example.demo;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class CustomerController {

	public static void main(String[] args) {
		SpringApplication.run(CustomerController.class, args);
	}

}
