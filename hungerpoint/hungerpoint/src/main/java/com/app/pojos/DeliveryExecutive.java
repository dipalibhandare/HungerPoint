package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="delivery_executives")
public class DeliveryExecutive {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer deliveryExecutiveId;
	
	@Column(length=50,nullable = false)
	private String firstName;
	@Column(length=50,nullable=false)
	private String lastName;
	@Column(length = 10,unique = true)
	private String phoneNumber;
	@Column(length=70,nullable = false)
	private String emailId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private LocalDate registrationDate;
	
	@Column(unique=true)
	private long socialSecurityNumber;
	
	
	private String image;
	
	
	@Column(nullable = false)
	private String status;

	@JsonIgnoreProperties("deliveryExecutive")
	@OneToOne
	@JoinColumn(name="loginId",nullable = false,unique = true)
		private Login login;
	
	@JsonIgnoreProperties("deliveryExecutive")
	@OneToOne
	@JoinColumn(name="addressId",nullable = false,unique = true)
		private Address address;
	
	
	@JsonIgnoreProperties("deliveryExecutive")
	@ManyToOne
	@JoinColumn(name="branchId")
		private Branch branch;
	
		/*
		 * @JsonIgnoreProperties("deliveryExecutive")
		 * 
		 * @OneToMany(mappedBy = "deliveryExecutive",cascade = CascadeType.ALL,fetch =
		 * FetchType.LAZY) private List<Order> order;
		 */

	public DeliveryExecutive() {
		super();
	}

	public DeliveryExecutive(String firstName, String lastName, String phoneNumber, String emailId,
			long socialSecurityNumber, String image, String status, Login login, Address address, Branch branch,
			List<Order> order) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.socialSecurityNumber = socialSecurityNumber;
		this.image = image;
		this.status = status;
		this.login = login;
		this.address = address;
		this.branch = branch;
	//	this.order = order;
	}

	
	public Integer getDeliveryExecutiveId() {
		return deliveryExecutiveId;
	}

	public void setDeliveryExecutiveId(Integer deliveryExecutiveId) {
		this.deliveryExecutiveId = deliveryExecutiveId;
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

	public long getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(long socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * public Login getLogin() { return login; }
	 */

	public void setLogin(Login login) {
		this.login = login;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/*
	 * public Branch getBranch() { return branch; }
	 */

	
	  public void setBranch(Branch branch) { this.branch = branch; }
	 

	/*
	 * public List<Order> getOrder() { return order; }
	 * 
	 * public void setOrder(List<Order> order) { this.order = order; }
	 */

	@Override
	public String toString() {
		return "DeliveryExecutive [deliveryExecutiveId=" + deliveryExecutiveId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", socialSecurityNumber=" + socialSecurityNumber + ", image=" + image + ", status="
				+ status + ", login=" + login + ", address=" + address + ", branch=" + branch + ", order=" + "]";
	}
	
	
}
