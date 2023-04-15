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

import mateus_goulart.prova1.orderDTO.OrderDTO;
import mateus_goulart.prova1.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createOrder(@RequestBody OrderDTO entity) {
		service.createOrder(entity);
	}
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<OrderDTO> getAllProducts() {
		return service.findAll();
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long code) {
		OrderDTO objDTO = new OrderDTO (service.findById(code));
		return ResponseEntity.ok().body(objDTO);
	}
	
	@PutMapping("handleActive/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<OrderDTO> handleActive(@PathVariable Long code) {
		OrderDTO objDTO = new OrderDTO (service.handleActive(code));
		return ResponseEntity.ok().body(objDTO);
	}
	
}
