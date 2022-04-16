package com.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Branch;
import com.app.pojos.Order;
@Repository
@Transactional
public interface BranchRepository extends JpaRepository<Branch, Integer> {
	
	@Query(value="select * from branches b join address a on b.address_id=a.address_id",nativeQuery = true)
	public List<Branch> viewBranches();
	
	@Query("select b from Branch b join fetch b.order")
	public List<Branch> getBranchOrders();
	
	@Query("select b from Branch b join fetch b.order ")
	public List<Branch> getCustomerOrderDetails(Integer br_id);
	
	

}
