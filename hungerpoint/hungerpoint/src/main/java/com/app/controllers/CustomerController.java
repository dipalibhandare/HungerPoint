package com.app.controllers;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Address;
import com.app.pojos.Customer;
import com.app.pojos.Login;
import com.app.pojos.Menu;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;
import com.app.pojos.OrderItem;
import com.app.pojos.RegisterCustomer;
import com.app.service.AddressService;
import com.app.service.CustomerService;
import com.app.service.LoginService;
import com.app.service.MenuService;
import com.app.service.OrderItemService;
import com.app.service.OrderService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private AddressService addressService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody RegisterCustomer rcust)
	{
		Address addr=new Address(rcust.getStreetAddress(), rcust.getCity(), rcust.getCountry(), rcust.getZipcode());
		Address persistentaddr=addressService.save(addr);
		Login login=new Login("customer", rcust.getPassword(), rcust.getPhoneNumber() );
		Login persistentlogin=loginService.save(login);
		Customer cust=new Customer(rcust.getFirstName(), rcust.getLastName(), rcust.getPhoneNumber(), rcust.getEmailId(), persistentaddr, persistentlogin);
		Customer persistentcust=customerService.save(cust);
			return persistentcust;
	}
	@GetMapping("/getAll")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAll();
		 
	}
	
	@PostMapping("/login")
	public Object authenticate(String phoneNumber,String password )
	{
		
		return loginService.authenticate(phoneNumber, password); 
	}

	@PostMapping("/saveOrder")
	public void saveOrder(@RequestBody OrderDetails od)
	{
		System.out.println(od.getCustomerId()+" "+od.getMenuDetails());
			orderService.saveOrder(od);
			
		
		
				/*
		 * menu.setOrderItem(orderItem); for(Order i:order) i.setOrderitem(orderItem);
		 * 
		 * 
		 * cust.setOrder(order);
		 */
			       
		/*
		 * Customer persistentcust=customerService.save(cust); return persistentcust;
		 */	
		}
	
	@GetMapping("/getByCustIdOrders")
	public Customer getByCustIdOrder(@RequestParam Integer custId)
	{
		
		return customerService.getOrderCustomerById(custId);
//		javax.persistence.Query query= entityManager.createNativeQuery("select * from orders where  customer_id=?");
//		query.setParameter(1, custId);
//	      
//		List<Order> orderlist =query.getResultList();
//		
//		return orderlist;
		
		
	}
	
}
