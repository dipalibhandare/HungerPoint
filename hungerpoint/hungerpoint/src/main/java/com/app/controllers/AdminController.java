package com.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.plaf.multi.MultiButtonUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Address;
import com.app.pojos.Branch;
import com.app.pojos.BranchManager;
import com.app.pojos.Customer;
import com.app.pojos.Login;
import com.app.pojos.Menu;
import com.app.pojos.Order;
import com.app.pojos.RegisterBranchManager;
import com.app.pojos.RegisterCustomer;
import com.app.service.AddressService;
import com.app.service.BranchManagerService;
import com.app.service.BranchService;
import com.app.service.LoginService;
import com.app.service.MenuService;
import com.app.service.OrderItemService;
import com.app.service.OrderService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired 
	private BranchManagerService branchManagerService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
		private LoginService loginService;
	@Autowired
		private BranchService branchService;
	@Autowired
		private OrderService orderService;
		

	@PostMapping("/branchManager/register")
	public boolean registerBranchManger(@RequestPart RegisterBranchManager bMgr,@RequestPart("file") MultipartFile file )
	{    
		boolean returnValue=true;
		
		Address addr=new Address(bMgr.getStreetAddress(), bMgr.getCity(), bMgr.getCountry(), bMgr.getZipcode());
		Address persistentaddr=addressService.save(addr);
		Login login=new Login("branch_manager", bMgr.getPassword(), bMgr.getPhoneNumber() );
		Login persistentlogin=loginService.save(login);
		Branch br=branchService.getById(bMgr.getBranchId());
		
//public BranchManager(String firstName, String lastName, String phoneNumber, String emailId, String image, long socialSecurityNumber, Login login, Branch branch,
//		Address address) {
		byte[] data= {};
		try {
			 data=file.getBytes();
		}catch (Exception e) {
			returnValue=false; 
		}
		
		BranchManager mgr=new BranchManager(bMgr.getFirstName(), bMgr.getLastName(), bMgr.getPhoneNumber(), bMgr.getEmailId(),data,bMgr.getSocialSecurityNumber(),persistentlogin, br,persistentaddr );
		branchManagerService.save(mgr);
		/*
		 * try { byte[] data=file.getBytes();
		 * 
		 * Path p=Paths.get("images//"+mgr.getBranchManagerId()+".jpg"); Files.write(p,
		 * data); }catch (Exception e) { returnValue=false; }
		 */
		  return  returnValue;
		
	}
	
	@GetMapping("/branchManager/getAll")
	
	public List<BranchManager> getAll()
	{
	 return branchManagerService.getAll();	
	}
	
	@GetMapping("/getBranchOrders")
	public List<Branch> getOrderBranchOrders()
	{
		return branchService.getBranchOrders();
	}

	@GetMapping("/viewBranches")
	public List<Branch> viewBranches()
	{
	   return branchService.viewBranches();	
	}
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/menu/getAll")
	public List<Menu> getAllMenu()
	{
	 return	menuService.getAll();
	}
	
	@PostMapping("/menu/save")
	public Menu saveMenu(@RequestPart Menu obj,@RequestPart("file") MultipartFile file)
	{
		
		try {
			obj.setImage(file.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
		return menuService.save(obj);
	}
	
	@PutMapping("/menu/update")
	public boolean updateMenu(@RequestPart Menu obj,@RequestPart("file") MultipartFile file)
	{
		try {
			obj.setImage(file.getBytes());
			menuService.update(obj);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
	}
	
	@DeleteMapping("/menu/delete/{id}")
	public boolean deleteMenu(@PathVariable Integer id )
	{
		return menuService.delete(id);
	}
}
