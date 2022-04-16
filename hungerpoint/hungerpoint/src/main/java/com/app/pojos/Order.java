package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
		
	//@Column(nullable = false)
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private LocalDate orderDate;
	
	//@Column(nullable = false)
	@Column(columnDefinition = "DATE DEFAULT CURRENT_TIME")
	private LocalTime orderTime;
	
	//@Column(nullable = false)
	private double totalAmount;
	
	
	@Column(nullable = false,length = 20)
	private String orderStatus;
	
	@JsonIgnoreProperties("order")
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	
	
	  @JsonIgnoreProperties("order")
	  
	  @ManyToOne
	  
	  @JoinColumn(name="deliveryExecutiveId") 
	  private DeliveryExecutive  deliveryExecutive;
	 
	
	@JsonIgnoreProperties("order")
	@ManyToOne
	@JoinColumn(name="branchId")
	private Branch branch; 
	
	@JsonIgnoreProperties("order")
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<OrderItem> orderItem=new ArrayList<OrderItem>();

	public Order() {
		super();
	}

	

	public Order(double totalAmount, String orderStatus, Customer customer, DeliveryExecutive deliveryExecutive,
			Branch branch, List<OrderItem> orderItem) {
		super();
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.deliveryExecutive = deliveryExecutive;
		this.branch = branch;
		this.orderItem = orderItem;
	}

	


	public Order(double totalAmount, String orderStatus, Customer customer, Branch branch, List<OrderItem> orderItem) {
		super();
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.branch = branch;
		this.orderItem = orderItem;
	}



	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	

	public LocalTime getOrderTime() {
		return orderTime;
	}

	

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	
	  public Customer getCustomer() { return customer; }
	 


	/*
	 * public DeliveryExecutive getDeliveryExecutive() { return deliveryExecutive; }
	 * 
	 */

	/*
	 * public Branch getBranch() { return branch; }
	 */



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	  public void setDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
	  this.deliveryExecutive = deliveryExecutive; }
	 
	
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	/*
	 * public List<OrderItem> getOrderitem() { return orderItem; }
	 */

	public void setOrderitem(List<OrderItem> orderitem) {
		this.orderItem = orderitem;
		for(OrderItem i:orderitem)
		{
			i.setOrder(this);
		}
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderTime=" + orderTime + ", totalAmount="
				+ totalAmount + ", orderStatus=" + orderStatus + ", orderitem=" + orderItem + "]";
	}
	
	
	
	
	
}
