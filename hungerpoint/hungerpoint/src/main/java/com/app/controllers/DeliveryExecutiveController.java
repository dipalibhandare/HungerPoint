package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Order;
import com.app.service.DeliveryExecutiveService;
import com.app.service.OrderService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/deliveryExecutive")
public class DeliveryExecutiveController {
	
	@Autowired
		private OrderService orderService;
	
	@Autowired
		private DeliveryExecutiveService deliveryExecutiveService;
	
	@GetMapping("/getAssignedOrders")
	public List<Order> getAssignedOrders(@RequestParam Integer deliveryExecutiveId)
	{
		return orderService.getAssignedOrders(deliveryExecutiveId);
	}
	
	@PutMapping("/updateToAvailable")
	public boolean updateToAvailable(@RequestParam Integer deliveryExecutiveId)
	{	try {
		deliveryExecutiveService.updateToAvailable(deliveryExecutiveId);
		return true;
	       } catch (Exception e) {
		// TODO: handle exception
	    	   return false;
	      }
		
	}
	
	@PutMapping("/updateDExeOrderStatus")
	public boolean updateDExeOrderStatus(@RequestParam Integer deliveryExecutiveId,Integer orderId,String status)
	{	try {
		orderService.updateDExeOrderStatus(deliveryExecutiveId, orderId,status);
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		return true;
	}
		
	}
	
	@GetMapping("/getDeliveredOrders")
	public List<Order> getDeliveredOrders(@RequestParam Integer deliveryExecutiveId)
	{
		return orderService.getDeliveredOrders(deliveryExecutiveId);
	}
}
