package com.app.repository;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;
import com.app.service.OrderItemService;

@Transactional
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
//	SELECT a FROM Author a LEFT JOIN FETCH a.books
	//@Query(value="select order_id, order_date, order_status , order_time, total_amount , b.branch_name from orders o,branches b where o.branch_id=b.branch_id",nativeQuery = true)
	
	//@Query(value="select new com.app.pojos.Order(o.orderId) from orders o left join branches b on o.branch_id=b.branch_id",nativeQuery = true)
	//@Query("select new com.app.pojos.Order(o.orderId) from orders o left join branches b on o.branch_id=b.branch_id")
	
	@Query("select o from Order o join fetch o.customer where branch_id=:br_id")
	public List<Order> getCustomerOrderDetails(Integer br_id);

	@Query("select o from Order o where o.orderStatus='placed'")
	public List<Order> getAllPlacedOrders();
	
	@Modifying
	@Query(value="update orders o set o.delivery_executive_id=:deliveryExecutiveId where order_id=:orderId",nativeQuery = true)
	public void assignDeliveryExecutive(Integer orderId,Integer deliveryExecutiveId );
	
	@Modifying
	@Query(value="update orders o set order_status=:status where order_id=:orderId",nativeQuery = true)
	public void updateOrderStatus(Integer orderId,String status);
	
	@Query(value="select * from orders where delivery_executive_id=:deliveryExecutiveId and order_status='in_process'",nativeQuery = true)
	public List<Order> getAssignedOrders(Integer deliveryExecutiveId);
	
	@Modifying
	@Query(value="update orders o set order_status=:status where delivery_executive_id=:deliveryExecutiveId and order_id=:orderId",nativeQuery = true)
	public void updateDExeOrderStatus(Integer deliveryExecutiveId,Integer orderId,String status);
	
	@Query("select o from Order o join fetch o.customer where o.orderStatus='delivered' and delivery_executive_id=:deliveryExecutiveId")
	public List<Order> getDeliveredOrders(Integer deliveryExecutiveId);
	
	
	@Query(value="select * from orders c where c.customer_id=:id",nativeQuery = true)
	public Order getByIdOrder(Integer id);
		
	
}
