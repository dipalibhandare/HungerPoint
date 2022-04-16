package com.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.BranchManager;

@Repository
@Transactional
public interface BranchManagerRepository extends JpaRepository<BranchManager, Integer> {
	
	@Query(value="select * from branch_managers b,address a where b.address_id=a.address_id",nativeQuery =true)
	//public List<Object> getAll();
	public List<BranchManager> getAll();
}
