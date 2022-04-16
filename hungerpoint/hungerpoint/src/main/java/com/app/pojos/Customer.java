package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId; 
	
	@Column(length=50,nullable = false)
	private String firstName;
	@Column(length=50,nullable=false)
	private String lastName;
	@Column(length = 10,unique = true,nullable = false)
	private String phoneNumber;
	@Column(length=70,nullable = false)
	private String emailId;
	
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private LocalDate registrationDate;
	
	
	
	@JsonIgnoreProperties("customer")
	@OneToOne
	@JoinColumn(name="addressId")
	
	private Address address;
	
	@JsonIgnoreProperties("customer")
	@OneToOne
	@JoinColumn(name="loginId")
	private Login login;

	@JsonIgnoreProperties("customer")
	@OneToMany(mappedBy ="customer",cascade = CascadeType.ALL )
	
	private List<Order> order=new ArrayList<Order>();

	public Customer() {
		super();
	}

	//Customer cust=new Customer(rcust.getFirstName(), rcust.getLastName(), rcust.getPhoneNumber(), rcust.getEmailId(), persistentaddr, persistentlogin);
	public Customer( String firstName, String lastName, String phoneNumber,String emailId,
			Address address, Login login) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		
		this.address = address;
		this.login = login;
		
	}


	public Integer getCustomerId() {
		return customerId;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	

	public Address getAddress() {
		return address;
	}
	
	
	
	

	public void setAddress(Address address) {
		this.address = address;
	}

	
	  public Login getLogin() { return login; }
	 

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
		for(Order i:order)
		{
			i.setCustomer(this);
		}
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", registrationDate=" + registrationDate
				+ ", address=" + address + ", login=" + login + ", order=" + order + "]";
	}

	
	
	
}
