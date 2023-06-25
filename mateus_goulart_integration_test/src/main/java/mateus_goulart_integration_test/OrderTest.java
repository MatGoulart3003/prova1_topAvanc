package mateus_goulart_integration_test;

import org.apache.http.HttpStatus;
import org.junit.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mateus_goulart_integration_test.dto.OrderDTO;


public class OrderTest {
	
	private final String orderURL = "http://localhost:8080/order";
	
	@Test
	public void testCreateOrderSucess() {		
		Long orderNumber = 3L;
		Response resp = createOrderWithId(orderNumber);
		resp.then().assertThat().statusCode(HttpStatus.SC_CREATED);
	}
	
	
	@Test
	public void testGetbyIDSucess() {
		Long OrderNumber = 1L;
        Response resp = RestAssured.get(orderURL + "/" + OrderNumber);
        resp.then().assertThat().statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void testHandleActiveSuccess() {
		Long OrderNumber = 2L;
        Response resp = RestAssured.put(orderURL + "/handleActive/" + OrderNumber);
        resp.then().assertThat().statusCode(HttpStatus.SC_OK);
	}
	
	@Test
	public void testHandleActiveInvalid() {
		Long OrderNumber = 5L;
        Response resp = RestAssured.put(orderURL + "/handleActive/" + OrderNumber);
        resp.then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
	}
	
	@Test
	public void testGetbyIDInvalid() {
		Long OrderNumber = 5L;
        Response resp = RestAssured.get(orderURL + "/" + OrderNumber);
        resp.then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
	}
	
	
	
	private Response createOrderWithId(Long orderNumber) {
		OrderDTO order = new OrderDTO(orderNumber, 3, "111.111.111-66", 10, "24/06/2023", 12.5f);	
		Response resp = RestAssured.given().body(order).contentType(ContentType.JSON).post(orderURL);
		return resp;
	}
		
}
