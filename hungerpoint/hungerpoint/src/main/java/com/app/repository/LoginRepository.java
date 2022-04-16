package com.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.Login;

@Transactional
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
	
		@Query("select e from Login e where e.userphone=:phoneNumber and e.password=:password")
		
	public Login authenticate(String phoneNumber,String password);
		
		

}
