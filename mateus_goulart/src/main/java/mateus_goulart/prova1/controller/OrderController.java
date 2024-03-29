package mateus_goulart.prova1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mateus_goulart.prova1.entities.OrderEntity;
import mateus_goulart.prova1.orderDTO.OrderDTO;
import mateus_goulart.prova1.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO entity) {
		Long code = entity.getOrderNumber();
		OrderEntity orderChecked = service.findById(code);
		if(orderChecked == null) {
			service.createOrder(entity);
			return ResponseEntity.ok(entity);
		}else {
			return ResponseEntity.badRequest().build();
		}
		
		
	}
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<OrderDTO> getAllProducts() {
		return service.findAll();
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long code) {		
		OrderEntity orderChecked = service.findById(code);

		System.out.println(orderChecked);
		
		if(orderChecked == null) {
			return ResponseEntity.notFound().build();
			
		}else {
			OrderDTO objDTO = new OrderDTO (orderChecked);
			return ResponseEntity.ok().body(objDTO);
	
		}	
	}
	
	@PutMapping("/handleActive/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<OrderDTO> handleActive(@PathVariable Long code) {
		
		OrderEntity orderChecked = service.findById(code);
		if(orderChecked == null) {
			return ResponseEntity.notFound().build();
		}else {

			OrderDTO objDTO = new OrderDTO (service.handleActive(code));
			return ResponseEntity.ok().body(objDTO);
		}
		
	}
	
}
