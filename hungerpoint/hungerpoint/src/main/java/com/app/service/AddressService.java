package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Address;
import com.app.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressrepo;

	public Address save(Address obj)
	{
		return addressrepo.save(obj);
	}
	
	public List<Address> getAll()
	{
		return addressrepo.findAll();
	}
}
