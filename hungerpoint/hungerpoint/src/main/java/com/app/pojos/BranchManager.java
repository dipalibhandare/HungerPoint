package com.app.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="branch_managers")
public class BranchManager {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer branchManagerId;
	
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
	
	
		@Lob
		private byte[] image;
	
	@Column(unique=true)
		private long socialSecurityNumber;
	
	@JsonIgnoreProperties("branchManager")
	@OneToOne
	@JoinColumn(name="loginId",nullable = false,unique = true)
	private Login login;
	
	@JsonIgnoreProperties("branchManager")
	@OneToOne
	@JoinColumn(name="branchId",nullable = false,unique = true)
	private Branch branch;
	
	@JsonIgnoreProperties("branchManager")
	@OneToOne
	@JoinColumn(name="addressId",nullable = false,unique = true)
	
	private Address address;


	public BranchManager() {
		super();
	}


	public BranchManager(String firstName, String lastName, String phoneNumber, String emailId, byte [] image, long socialSecurityNumber, Login login, Branch branch,
			Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		
		this.image = image;
		this.socialSecurityNumber = socialSecurityNumber;
		this.login = login;
		this.branch = branch;
		this.address = address;
	}


	public Integer getBranchManagerId() {
		return branchManagerId;
	}


	public void setBranchManagerId(Integer branchManagerId) {
		this.branchManagerId = branchManagerId;
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

	/*
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	*/
	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public long getSocialSecurityNumber() {
		return socialSecurityNumber;
	}


	public void setSocialSecurityNumber(long socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

   /*
	public Login getLogin() {
		return login;
	}
*/

	public void setLogin(Login login) {
		this.login = login;
	}

	/*
	public Branch getBranch() {
		return branch;
	}
	*/

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	
	public Address getAddress() {
		return address;
	}
	


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "BranchManager [branchManagerId=" + branchManagerId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", registrationDate="
				+ registrationDate + ", image=" + image + ", socialSecurityNumber="
				+ socialSecurityNumber + ", login=" + login + ", branch=" + branch + ", address=" + address + "]";
	}


	
	


}
