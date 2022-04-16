package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Menu;
import com.app.service.MenuService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/getAll")
	public List<Menu> getAllMenu()
	{
	 return	menuService.getAll();
	}
	
	@PostMapping("/save")
	public Menu saveMenu(@RequestBody Menu obj)
	{
		return menuService.save(obj);
	}
	
	/*
	 * @PutMapping("/update") public Menu updateMenu(@RequestBody Menu obj) { return
	 * menuService.update(obj);
	 * 
	 * }
	 */
	
	@DeleteMapping("/{id}")
	public boolean deleteMenu(@PathVariable Integer id )
	{
		return menuService.delete(id);
	}
}
