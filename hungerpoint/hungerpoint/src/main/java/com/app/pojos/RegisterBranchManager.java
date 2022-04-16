package com.app.pojos;

public class RegisterBranchManager {

	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;

	private String emailId;
	
//	private String role; give default customer in login() constructor
	
	//3. public Customer(String firstName, String lastName, String phoneNumber, String emailId,
//	Address address, Login login) 
		
	private String password;
	//2 .public Login(String role="customer", String password, String userphone ) {
	
	private String streetAddress;
	
	private String city;
	
	private String country;
	
	private int zipcode;
	
//	private byte[] image;
	
	private long socialSecurityNumber;
	
	private int branchId;
	//1. public Address(String streetAddress, String city, String country, int zipcode) {

	public RegisterBranchManager(String firstName, String lastName, String phoneNumber, String emailId, String password,
			String streetAddress, String city, String country, int zipcode,long socialSecurityNumner,int branchId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
		this.streetAddress = streetAddress;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		//this.image=image;
		this.socialSecurityNumber=socialSecurityNumber;
		this.branchId=branchId;
	}
	
	
	public int getBranchId() {
		return branchId;
	}


	public void setBranchId(int branchId) {
		this.branchId = branchId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	/*
	 * public byte[] getImage() { return image; }
	 * 
	 * public void setImage(byte[] image) { this.image = image; }
	 */

	public long getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(long socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	

}
