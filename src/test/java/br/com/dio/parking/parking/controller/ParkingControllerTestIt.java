package br.com.dio.parking.parking.controller;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import br.com.dio.parking.parking.dto.ParkingCrateDto;
import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ParkingControllerTestIt {
	
	@LocalServerPort
	private int port;
	
	@BeforeEach
	public void setUpTest() {
		RestAssured.port = port;
	}

	@Test
	void whwnFindAllThenChekResult() {
		RestAssured.given()
		           .when()
		           .get("/parking")
		           .then()
		           .statusCode(200)
		           .body("color[0]", Matchers.equalTo("vermelho"));
	}
	@Test
	void testCreate() {
		ParkingCrateDto dto = new ParkingCrateDto();
		dto.setLicense("5123");
		dto.setState("ro");
		dto.setModel("gol");
		dto.setColor("vermelho");
		
		RestAssured.given()
		           .when()
		           .contentType(MediaType.APPLICATION_JSON_VALUE)
		           .body(dto)
		           .post("/parking")
		           .then()
		           .statusCode(201)
		           .body("color", Matchers.equalTo("vermelho"));
	}

}
