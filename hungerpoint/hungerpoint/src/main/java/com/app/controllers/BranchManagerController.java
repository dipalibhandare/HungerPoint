package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Branch;
import com.app.pojos.Customer;
import com.app.pojos.DeliveryExecutive;
import com.app.pojos.Order;
import com.app.service.CustomerService;
import com.app.service.DeliveryExecutiveService;
import com.app.service.OrderService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/branchManager")
public class BranchManagerController {
	
	@Autowired
		private CustomerService customerService;
	@Autowired
		private OrderService orderService;
	
	@Autowired
		private DeliveryExecutiveService deliveryExecutiveService;
		
	@GetMapping("/getCustomerOrder")
	public List<Order> getCustomerOrderDetails(@RequestParam Integer br_id)
	{
		
		return  orderService.getCustomerOrderDetails(br_id);
	}
	@GetMapping("/getAllPlacedorders")
	public List<Order> getAllPlacedOrders()
	{
			return orderService.getAllPlacedOrders();
	}
	
	@PutMapping("/assignDeliveryExecutive")//orderId,deliveryExecutiveId
	public boolean assignDeliveryExecutive(@RequestParam Integer orderId,Integer deliveryExecutiveId )
	{
		try {
			orderService.assignDeliveryExecutive(orderId,deliveryExecutiveId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		 
	}
	
	@PutMapping("/updateOrderStatus")
	public boolean updateOrderStatus(@RequestParam Integer orderId,String status)
	{   try {
		orderService.updateOrderStatus(orderId, status);
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		return false;
	}
			
	}
	
	@GetMapping("/getAvailableDeliveryExecutive")
	public List<DeliveryExecutive> getAvailableDeliveryExecutive(@RequestParam Integer branchId)
	{
		return deliveryExecutiveService.getAvailableDeliveryExecutive(branchId);
	}
}
