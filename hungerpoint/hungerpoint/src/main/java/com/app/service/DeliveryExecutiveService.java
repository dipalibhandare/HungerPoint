package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.DeliveryExecutive;
import com.app.repository.DeliveryExecutiveRepository;

@Service
public class DeliveryExecutiveService {

	@Autowired
		private DeliveryExecutiveRepository deliveryExecutiveRepo;
	
	public List<DeliveryExecutive> getAvailableDeliveryExecutive(Integer branchId)
	{
		return deliveryExecutiveRepo.getAvailableDeliveryExecutive(branchId);
	}
	
	public void updateToAvailable(Integer deliveryExecutiveId)
	{
		deliveryExecutiveRepo.updateToAvailable(deliveryExecutiveId);
	}
}
