package mateus_goulart.prova1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mateus_goulart.prova1.entities.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	public List<OrderEntity>findByActive(Boolean active);
	
}
