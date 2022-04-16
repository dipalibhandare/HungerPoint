package com.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Branch;
import com.app.pojos.Customer;
import com.app.pojos.Login;
import com.app.pojos.Order;

@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {
	
	
	
	@Query(value="select * from customers c where c.order_id=:loginId",nativeQuery = true)
	public Customer getByLoginId(Integer loginId);
	
	/*
	 * @Query(
	 * value="select * from customers c,address a,orders o,branch b where c.address_id=a.address and c.order_id=o.order_id and b.branch_id=:br_id"
	 * ,nativeQuery = true) public List<Customer> getCustomerOrderDetails(Integer
	 * br_id);
	 */

	@Query("select c from Customer c  where login=:loginId")
	public Customer getCustByLoginId(Login loginId);
	
	@Query("select c from Customer c where customer_id=:custId")
	public Customer getOrderCustomerById(int custId);
}
