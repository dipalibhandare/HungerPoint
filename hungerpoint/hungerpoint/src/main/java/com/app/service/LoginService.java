package com.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Customer;
import com.app.pojos.Login;
import com.app.repository.CustomerRepository;
import com.app.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginrepo;
	@Autowired
	CustomerRepository customerRepo;
	@PersistenceContext
	EntityManager entityManager;
	
	public Login save(Login obj)
	{
		return loginrepo.save(obj);
	}
	public List<Login> getAll()
	{
		return loginrepo.findAll();
	}
	
	public Object authenticate(String phoneNumber, String password)
	{
		Object object=null;
		Login ob=loginrepo.authenticate(phoneNumber, password);
		System.out.println("Login ID=="+ob.getLoginId());
		if(ob.getRole().equals("customer"))
		{
		Customer cust=customerRepo.getCustByLoginId(ob);	
	//	Customer cust=customerRepo.getCustByLoginId(ob.getLoginId());
		/*
		 * Query query=entityManager.
		 * createNativeQuery("select c from Customer c  where loginId=?")
		 * .setParameter(1, ob.getLoginId());
		 * 
		 * object=query.getSingleResult();
		 */
			//System.out.println(object);
		return cust;
		}
		else if(ob.getRole()=="admin")
		{
			
		}
		else if(ob.getRole()=="branch_manager")
		{
		}
		else if(ob.getRole()=="delivery_executive")
		{
			
		}
		return object;
	}
}
