package mateus_goulart.prova1.orderDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import mateus_goulart.prova1.entities.OrderEntity;

@Data
@NoArgsConstructor
public class OrderDTO {

	private Long orderNumber;
	private int productCode;
	private String cpf;
	private int amount;
	private String dateOfTheSale;
	private float orderValue;
	
	public OrderDTO(OrderEntity order) {
		this.orderNumber = order.getOrderNumber();
		this.productCode = order.getProductCode();
		this.cpf = order.getCpf();
	 	this.amount = order.getAmount();
	 	this.dateOfTheSale = order.getDateOfTheSale();
	 	this.orderValue = order.getOrderValue();
	 	

	}
	
}
