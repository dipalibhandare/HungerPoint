package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="order_items")
public class OrderItem {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer orderItemId;
	
	
	private double amount;
	
	@Column(nullable = false)
	private int quantity;
	
	@JsonIgnoreProperties("orderItem")
	@ManyToOne
	@JoinColumn(name="menuId")
	private Menu menu;
	
	@JsonIgnoreProperties("orderItem")
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;

	public OrderItem() {
		super();
	}

	

	public OrderItem(double amount, int quantity, Menu menu, Order order) {
		super();
		this.amount = amount;
		this.quantity = quantity;
		this.menu = menu;
		this.order = order;
	}



	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public Menu getMenu() {
		return menu;
	}



	public void setMenu(Menu menu) {
		this.menu = menu;
	}



	

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [amount=" + amount + ", quantity=" + quantity + ", menu=" + menu + ", order=" + order + "]";
	}
	
	
	
	
}
