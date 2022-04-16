package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.BranchManager;
import com.app.repository.BranchManagerRepository;

@Service
public class BranchManagerService {
	
	@Autowired
	 private BranchManagerRepository branchManagerRepo;
	
	public boolean save(BranchManager ob)
	{
		try {
			branchManagerRepo.save(ob);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	//public List<Object> getAll()
	public List<BranchManager> getAll()
	{
		return branchManagerRepo.getAll();
	}

}
