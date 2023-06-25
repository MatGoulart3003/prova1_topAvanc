package mateus_goulart.prova1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mateus_goulart.prova1.entities.OrderEntity;
import mateus_goulart.prova1.orderDTO.OrderDTO;
import mateus_goulart.prova1.repository.OrderRepository;

@Service
public class OrderService {
	
	private OrderRepository repo;
	
	@Autowired
	public OrderService (OrderRepository repo) {
		this.repo = repo;
	}
	
	public List<OrderDTO> findAll(){
		return repo.findAll()
				.stream()
				.map(p -> new OrderDTO(p))
				.collect(Collectors.toList());
	}
	
	public void createOrder (OrderDTO order) {
		Optional<OrderEntity> obj = repo.findById(order.getOrderNumber());
		if (obj == null) {
			repo.save(toEntity(order));
		}else {
			obj.orElse(null);
		}
		
	}
	
	public OrderEntity toEntity (OrderDTO order) {
				return new OrderEntity(order.getOrderNumber(), order.getProductCode(),
				order.getCpf(), order.getAmount(), order.getDateOfTheSale(),
				order.getOrderValue(), true);
		}
	
	public OrderEntity findById (Long id) {
		Optional<OrderEntity> obj = repo.findById(id);
		OrderEntity entity = obj.orElse(null);
		return entity;
	}
	
	public OrderEntity handleActive (Long id) {
		Optional<OrderEntity> obj = repo.findById(id);
		OrderEntity entity = obj.orElse(null);
		entity.setActive(!entity.isActive());
		repo.save(entity);	
		return entity;
	}
	
}
