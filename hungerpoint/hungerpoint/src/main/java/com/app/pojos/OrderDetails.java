package com.app.pojos;

import java.util.List;

public class OrderDetails
{
  Integer customerId;
  Integer branchId;
  List<MenuDetails> menuDetails;
  

public List<MenuDetails> getMenuDetails() {
	return menuDetails;
}

public void setMenuDetails(List<MenuDetails> menuDetails) {
	this.menuDetails = menuDetails;
}

public Integer getCustomerId() {
	return customerId;
}

public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}

public Integer getBranchId() {
	return branchId;
}

public void setBranchId(Integer branchId) {
	this.branchId = branchId;
}
 
}


