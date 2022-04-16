package com.app.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Login;
import com.app.pojos.Menu;

@Transactional
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{
	
//	@Query("select m.menuId,m.menuName,m.category,m.image,m.rate from Menu m") //getting output as object needed as json
	//so better use fetchType=lazy and avoid getting list of order item and further all tables details
	//@Query(value="select menu_id,menu_name,category,image,rate from Menu" , nativeQuery = true)
	//public List<Object> getAll();

	@Modifying
	@Query(value="update menus set menu_name=:menuName, category=:category,rate=:rate,image=:image where menu_id=:menuId",nativeQuery = true)
	public void update( Integer menuId,String menuName,String category,double rate,byte[] image);
	
	
	@Query(value="select * from menus",nativeQuery = true)
	public List<Menu> getMenu();
}
