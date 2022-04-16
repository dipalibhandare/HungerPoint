package com.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.DeliveryExecutive;
import com.app.pojos.Order;

@Transactional
@Repository
public interface DeliveryExecutiveRepository extends JpaRepository<DeliveryExecutive, Integer> {

	@Query(value="select * from delivery_executives where branch_id=:branchId and status='available'",nativeQuery = true)
	public List<DeliveryExecutive> getAvailableDeliveryExecutive(Integer branchId);
	
	@Modifying
	@Query(value="update delivery_executives set status='available' where delivery_executive_id=:deliveryExecutiveId",nativeQuery = true)
	public void updateToAvailable(Integer deliveryExecutiveId);
	
	
}
