package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Login;
import com.app.pojos.LoginDetails;
import com.app.service.LoginService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
		private LoginService loginService;

	@PostMapping("/login")
	public Object authenticate(@RequestBody LoginDetails ob)
	{
		System.out.println(ob.getPhoneNumber()+" "+ob.getPassword());
		return loginService.authenticate(ob.getPhoneNumber(), ob.getPassword()); 
	}
}
