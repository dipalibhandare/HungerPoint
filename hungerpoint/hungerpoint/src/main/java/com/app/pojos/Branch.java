package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "branches")
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer branchId;

	@Column(length = 30, nullable = false)
	private String branchName;

	@JsonIgnoreProperties("branch")
	@OneToOne
	@JoinColumn(name = "addressId")

	private Address address;

	@JsonIgnoreProperties("branch")
	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> order = new ArrayList<>();

	@JsonIgnoreProperties("branch")
	@OneToOne(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BranchManager branchManager;

	@JsonIgnoreProperties("branch")

	@OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DeliveryExecutive> deliveryExecutive = new ArrayList<DeliveryExecutive>();

	public Branch() {
		super();
	}

	public Branch(String branchName, Address address, List<Order> order, BranchManager branchManager,
			List<DeliveryExecutive> deliveryExecutive) {
		super();
		this.branchName = branchName;
		this.address = address;
		this.order = order;
		this.branchManager = branchManager;
		this.deliveryExecutive = deliveryExecutive;
	}

	public Branch(Integer branchId, String branchName, Address address) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.address = address;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Address getAddress() {
		return address;
	}

	
	  public List<Order> getOrder() { return order; }
	 

	/*
	 * public void setAddress(Address address) { this.address = address; }
	 * 
	 * public List<Order> getOrder() { return order; }
	 */
	public void setOrder(List<Order> order) {
		this.order = order;
		for (Order i : order) {
			i.setBranch(this);
		}
	}

	/*
	 * public BranchManager getBranchManager() { return branchManager; }
	 * 
	 * public void setBranchManager(BranchManager branchManager) {
	 * this.branchManager = branchManager; }
	 * 
	 * 
	 * /* public List<DeliveryExecutive> getDeliveryExecutive() { return
	 * deliveryExecutive;
	 * 
	 * }
	 */
	public void setDeliveryExecutive(List<DeliveryExecutive> deliveryExecutive) {
		this.deliveryExecutive = deliveryExecutive;
		for (DeliveryExecutive i : deliveryExecutive) {
			i.setBranch(this);
		}
	}

	/*
	 * public void addDeliveryExcecutive(DeliveryExecutive deliveryExecutiveobj) {
	 * deliveryExecutive.add(deliveryExecutiveobj);
	 * deliveryExecutiveobj.setBranch(this);
	 * 
	 * } public void removeDeliveryExecutive(DeliveryExecutive deliveryExecutiveobj)
	 * { deliveryExecutive.remove(deliveryExecutiveobj);
	 * deliveryExecutiveobj.setBranch(null); }
	 */
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", address=" + address + ", order="
				+ order + ", branchManager=" + branchManager + "]";
	}
	
	

}
