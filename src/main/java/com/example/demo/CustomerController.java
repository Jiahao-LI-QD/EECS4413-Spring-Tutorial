package com.example.demo;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomerController {

	public static void main(String[] args) {
		SpringApplication.run(CustomerController.class, args);
	}

	private final CustomerService customerService;

	@GetMapping
	public List<Customer> getCustomers(){
		return this.customerService.findAllCustomers();
	}

	public record NewCustomerRequest(String name, String email, Integer age){}

	@PostMapping
	public void addCustomer(@Valid @RequestBody NewCustomerRequest request){
		Customer customer = new Customer();
		customer.setName(request.name());
		customer.setAge(request.age());
		customer.setEmail(request.email());
		customerService.saveCustomer(customer);
	}

	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id){
		customerService.deleteCustomerById(id);
	}

	@PutMapping("{customerId}")
	public void updateCustomer(@PathVariable("customerId") Integer id, @Valid @RequestBody NewCustomerRequest request){
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(request.name());
		customer.setAge(request.age());
		customer.setEmail(request.email());
		customerService.saveCustomer(customer);
	}

}
