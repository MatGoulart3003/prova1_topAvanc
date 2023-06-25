package mateus_goulart_integration_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	
	private Long orderNumber;
	private int productCode;
	private String cpf;
	private int amount;
	private String dateOfTheSale;
	private float orderValue;
	
	
	
}
