package mateus_goulart.prova1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mateus_goulart.prova1.entities.OrderEntity;
import mateus_goulart.prova1.repository.OrderRepository;

@SpringBootApplication
public class OrderApp implements CommandLineRunner{
	
	@Autowired
	private OrderRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(OrderApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		OrderEntity o1 = new OrderEntity(1l, 3 , "111.222.333-54", 5, "15/03/2012", 12.2f, true);
		repo.save(o1);
		OrderEntity o2 = new OrderEntity(2l, 3 , "333.222.333-54", 4, "15/03/2022", 12.2f, false);
		repo.save(o2);
		
	}

}
