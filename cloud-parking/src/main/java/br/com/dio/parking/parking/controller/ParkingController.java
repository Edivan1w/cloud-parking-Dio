package br.com.dio.parking.parking.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.parking.parking.dto.ParkingDto;
import br.com.dio.parking.parking.mapper.ParkingMapper;
import br.com.dio.parking.parking.model.Parking;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	
	
	@GetMapping
	public List<ParkingDto> findAll(){
		Parking parking = new Parking();
		parking.setColor("Amarelo");
		ParkingMapper mapper = new ParkingMapper();
		
		return mapper.parkingToList(Arrays.asList(parking));
		
	}
	

}
