package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Branch;
import com.app.repository.BranchRepository;

@Service
public class BranchService {

	@Autowired
	 private BranchRepository branchRepo;
	
	public Branch getById(Integer id)
	{
		return branchRepo.getById(id);
	}
	
	public List<Branch> viewBranches()
	{
	   return branchRepo.viewBranches();	
	}
	
	public List<Branch> getBranchOrders()
	{
		return branchRepo.getBranchOrders();
	}
	
	
	}

