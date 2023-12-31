package com.example.CustomerBackend.controller;

import com.example.CustomerBackend.dto.OrderRequest;
import com.example.CustomerBackend.enitity.Customer;
import com.example.CustomerBackend.repository.CustomerRepository;
import com.example.CustomerBackend.repository.DependentRepository;
import com.example.CustomerBackend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DependentRepository dependentRepository;

     @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }
}
