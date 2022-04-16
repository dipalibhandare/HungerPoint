package com.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Branch;
import com.app.pojos.Customer;
import com.app.pojos.Menu;
import com.app.pojos.MenuDetails;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;
import com.app.pojos.OrderItem;
import com.app.repository.BranchRepository;
import com.app.repository.CustomerRepository;
import com.app.repository.MenuRepository;
import com.app.repository.OrderItemRepository;
import com.app.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
		
	@Autowired
	private OrderRepository orderRepo;
	
	@PersistenceContext
		private EntityManager entityManager;
	@Autowired
		private CustomerRepository customerRepo;
	
	@Autowired
		private BranchRepository branchRepo;
	
	@Autowired
		private MenuRepository menuRepo;
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	public Order save(Order obj)
	{
		return orderRepo.save(obj);
	}
	public List<Order> getCustomerOrderDetails(Integer br_id)
	{
			return orderRepo.getCustomerOrderDetails(br_id);
	}
	
	public List<Order> getAllPlacedOrders()
	{
	      return orderRepo.getAllPlacedOrders();
	}
	
	public void assignDeliveryExecutive(Integer orderId,Integer deliveryExecutiveId )
	{
		 orderRepo.assignDeliveryExecutive(orderId,deliveryExecutiveId);
	}
	
	public void updateOrderStatus(Integer orderId,String status)
	{
        orderRepo.updateOrderStatus(orderId,status);
	}
	
	public List<Order> getAssignedOrders(Integer deliveryExecutiveId)
	{
	     return orderRepo.getAssignedOrders(deliveryExecutiveId);
	}
	
	public void updateDExeOrderStatus(Integer deliveryExecutiveId,Integer orderId,String status)
	{
		orderRepo.updateDExeOrderStatus(deliveryExecutiveId, orderId,status);
	}
	
	public List<Order> getDeliveredOrders(Integer deliveryExecutiveId)
	{
		return orderRepo.getDeliveredOrders(deliveryExecutiveId);
	}
	public Order getByIdOrder(Integer id)
	{
		return orderRepo.getByIdOrder(id);
	}
	public void saveOrder(OrderDetails od)
	{
		entityManager.createNativeQuery("INSERT INTO orders (order_status,total_amount,branch_id,customer_id) VALUES (?,?,?,?)")
	      .setParameter(1, "placed")
	      .setParameter(2, 0.0)
	      .setParameter(3, od.getBranchId())
	      .setParameter(4, od.getCustomerId())
	      .executeUpdate();
		
		javax.persistence.Query query= entityManager.createNativeQuery("select order_id from orders where branch_id=? and customer_id=? and total_amount=?");
		query.setParameter(1, od.getBranchId())
	      .setParameter(2, od.getCustomerId())
	      .setParameter(3, 0.0);
		Integer orId=(Integer)query.getSingleResult();
		
		double total_amt=0.0;
		for(MenuDetails i:od.getMenuDetails())
		{
			Integer menuId=i.getMenuId();
			query= entityManager.createNativeQuery("select rate from menus where menu_id=?");
			query.setParameter(1, menuId);
			double rate=(double)query.getSingleResult();
			double amount=rate*i.getQuantity();
			total_amt=total_amt+amount;
			entityManager.createNativeQuery("INSERT INTO order_items (amount,quantity,menu_id,order_id) VALUES (?,?,?,?)")
		      .setParameter(1, amount)
		      .setParameter(2, i.getQuantity())
		      .setParameter(3, i.getMenuId())
		      .setParameter(4,orId)
		      .executeUpdate();
			
			
		}	
		entityManager.createNativeQuery("update orders set total_amount=? where order_id=?")
	      .setParameter(1, total_amt)
	      .setParameter(2, orId)
	      .executeUpdate();
		
		/*
		Menu menu;
		Order or=new Order();
		Customer cust=customerRepo.getById(od.getCustomerId());
		Branch br=branchRepo.getById(od.getBranchId());
		or.setCustomer(cust);
		or.setBranch(br);
		
		or.setOrderStatus("placed");
		Order ob=orderRepo.save(or);
		Integer orderId=ob.getOrderId();
		
		double total_amt=0.0;
		for(MenuDetails i:od.getMenuDetails())
		{
			Integer menuId=i.getMenuId();
			menu=menuRepo.getById(menuId);
			double rate=menu.getRate();
			
			OrderItem items=new OrderItem();
			
			items.setOrder(ob);
			
			items.setMenu(menu);
			items.setQuantity(i.getQuantity());
			double amt=menu.getRate()*i.getQuantity();
			items.setAmount(amt);
			orderItemRepo.save(items);
			
			total_amt=total_amt+amt;
			
		}
			or.setTotalAmount(total_amt);
			orderRepo.save(or);
		
		
		
		return cust;
		*/
	}
	}

