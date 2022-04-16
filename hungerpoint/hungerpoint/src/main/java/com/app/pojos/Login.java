package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="logins")
public class Login {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int loginId;
	
	@Column(length=20)
	private String role;
	
	@Column(length=20)
	private String password;
	
	@Column(length=10)
	private String userphone;

	@JsonIgnoreProperties("login")
	@OneToOne(mappedBy = "login",cascade =CascadeType.ALL )	
		private Customer customer;
	
	@JsonIgnoreProperties("login")
	@OneToOne(mappedBy = "login",cascade =CascadeType.ALL )	
		private BranchManager branchmanager;
	
	@JsonIgnoreProperties("login")	
    @OneToOne(mappedBy = "login",cascade =CascadeType.ALL )	
    	private DeliveryExecutive deliveryExecutive;


	public Login() {
		super();
	}


	public Login(String role, String password, String userphone ) {
		super();
		this.role = role;
		this.password = password;
		this.userphone = userphone;
		
		
	}


	public int getLoginId() {
		return loginId;
	}


	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserphone() {
		return userphone;
	}


	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}


	

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	

	public void setBranchmanager(BranchManager branchmanager) {
		this.branchmanager = branchmanager;
	}


	


	public void setDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
		this.deliveryExecutive = deliveryExecutive;
	}


	@Override
	public String toString() {
		return "Login [role=" + role + ", password=" + password + ", userphone=" + userphone +"]";
	}
	
	
    
}
