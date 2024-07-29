package edu.cafeteria.Services;
 

import edu.cafeteria.model.Order;
import edu.cafeteria.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void markAsReady(Order order) {
        
        order.setStatus("READY");
        orderRepository.save(order);
    }
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public void updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + orderId));
        order.setStatus(status);
        orderRepository.save(order);
    }

	public Optional<Order> findOrderById(Long orderId) {
		 return orderRepository.findById(orderId);
	}

	public int countByUserId(Long idd) {
		 return orderRepository.countByUserId(idd);
	}

	public int countBystatus(String string) {
		 
		return orderRepository.countByStatus(string);
	}

 
}

