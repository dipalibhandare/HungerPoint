package com.app.pojos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="menus")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer menuId;
	
	
	@Column(length=30,nullable = false)
	private String menuName;
	
	@Column(length=30,nullable = false)
	private String category;
	
	@Lob
	private byte[] image;
	
	@Column(nullable = false)
	private double rate;
	
	@JsonIgnoreProperties("menu")
	@OneToMany(mappedBy="menu",fetch = FetchType.LAZY)
	private List<OrderItem> orderItem=new ArrayList<OrderItem>();

	public Menu() {
		super();
	}

	

	public Menu(String menuName, String category, byte[] image, double rate) {
		super();
		this.menuName = menuName;
		this.category = category;
		this.image = image;
		this.rate = rate;
		
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	/*
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
    */
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
		for(OrderItem i:orderItem)
		{
			i.setMenu(this);
		}
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", category=" + category + ", image="
				+ Arrays.toString(image) + ", rate=" + rate +  "]";
	}
	
	
}
