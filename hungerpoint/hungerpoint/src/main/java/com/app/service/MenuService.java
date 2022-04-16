package com.app.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Menu;
import com.app.repository.MenuRepository;

@Service 
public class MenuService {

	@Autowired
	private MenuRepository menuRepo;
	
	
	public List<Menu> getAll()
	{
		//return menuRepo.getAll();
		return menuRepo.getMenu();
	}
	
	public Menu save(Menu obj)
	{
	return menuRepo.save(obj);
		
	}
	public void update(Menu obj)
	{
		
		menuRepo.update(obj.getMenuId() ,obj.getMenuName(),obj.getCategory(),obj.getRate(),obj.getImage());
		
		
		/*
		 * Integer id=obj.getMenuId(); Menu menu=menuRepo.getById(id);
		 * menu.setCategory(obj.getCategory()); //ob.setImage(obj.getImage());
		 * menu.setMenuName(obj.getMenuName()); menu.setRate(obj.getRate());
		 * menuRepo.save(menu);
		 */
		
		/*
		Optional<Menu> ob = menuRepo.findById(id);
		Menu menu;
		try
		{
			menu = ob.get();
		menu.setCategory(obj.getCategory());
		//ob.setImage(obj.getImage());
		menu.setMenuName(obj.getMenuName());
		menu.setRate(obj.getRate());
		}
		catch(NoSuchElementException e)
		{
			menu = null;
		}*/
	//	return menu;
		
		
	}
	public boolean delete(Integer id)
	{
		
		try {
			menuRepo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
		return true;
		
		
		/*Integer id=obj.getMenuId();
		//Menu ob=menuRepo.getById(id);
		
		Optional<Menu> ob = menuRepo.findById(id);
		Menu menu;
		try
		{
			menu = ob.get();
			
			menuRepo.delete(menu);
		}
		catch(NoSuchElementException e)
		{
			menu = null;
		}
		
		return menu;
		*/
		
	}
}
