package service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import model.Order;
import model.Order.OrderStatus;
import repository.OrderRepository;

@Entity
public class OrderService {
	private final OrderRepository OrderRepository;
	
	@Autowired
	public OrderService(OrderRepository OrderRepository) {
		this.OrderRepository = OrderRepository;
	}
	
	public List<Order> getAllCategories() {
		return OrderRepository.findAll();
	}
	
	public Optional<Order> getOrderById(Long id) {
		return OrderRepository.findById(id);
	}
	
	public Order createOrder(Order Order) {
		return OrderRepository.save(Order);
	}
	
	public Optional<Order> updateOrder(Long id, LocalDateTime orderDate, OrderStatus status, BigDecimal totalAmount) {
		return OrderRepository.findById(id)
				.map(Order -> {
					Order.setOrderNumber(Order.getOrderNumber());
					Order.setStatus(Order.getStatus());
					return OrderRepository.save(Order);
				});
		}
	
	
	

}
