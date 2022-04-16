package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Branch;
import com.app.pojos.Customer;
import com.app.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerrepo;
	
	public Customer save(Customer obj)
	{
		return customerrepo.save(obj);
	}
	
	public List<Customer> getAll()
	{
		
		return customerrepo.findAll();
	}
	
	
	/*
	 * public List<Customer> getCustomerOrderDetails(Integer br_id) { return
	 * customerrepo.getCustomerOrderDetails(br_id); }
	 */
	public Customer getOrderCustomerById(int custId)
	{
			return customerrepo.getOrderCustomerById(custId);
	}
}
