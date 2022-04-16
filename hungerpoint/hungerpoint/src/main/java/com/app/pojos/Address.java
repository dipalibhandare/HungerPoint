package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Address_ID		Street address	City	Country	Zip code
//PK					

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private Integer addressId;
	
	@Column(length=50,nullable = false)
	private String streetAddress;
	@Column(length=50,nullable = false)
	private String city;
	@Column(length=50,nullable = false)
	private String country;
	@Column(length=50,nullable = false)
	private int zipcode;
	
	@JsonIgnoreProperties("address")
	@OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
	private Customer customer;
	
	@JsonIgnoreProperties("address")
	@OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
	private BranchManager branchManager;
	
	@JsonIgnoreProperties("address")
	@OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
	private DeliveryExecutive deliveryExecutive;
	
	@JsonIgnoreProperties("address")
	@OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
	private Branch branch;

	public Address() {
		super();
	}

	public Address(String streetAddress, String city, String country, int zipcode) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		
		
	}
	//BranchManager branchManager, DeliveryExecutive deliveryExecutive, Branch branch
	
	
	

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public void setBranchManager(BranchManager branchManager) {
		this.branchManager = branchManager;
	}

	

	public void setDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
		this.deliveryExecutive = deliveryExecutive;
	}

	

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
     */
	@Override
	public String toString() {
		return "Address [streetAddress=" + streetAddress + ", city=" + city + ", country=" + country + ", zipcode="
				+ zipcode +"]";
	}
	
	
	
	
}
