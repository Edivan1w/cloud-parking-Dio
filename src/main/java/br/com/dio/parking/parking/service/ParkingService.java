package br.com.dio.parking.parking.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.dio.parking.parking.model.Parking;

@Service
public class ParkingService {
	
	
	public List<Parking> findAll(){
		Parking parking = new Parking();
		parking.setId("123");
		parking.setColor("Amarelo");
		return Arrays.asList(parking);
	}
	
	public Parking findById(String id) {
		Parking parking = new Parking();
		parking.setId(id);
		parking.setColor("Amarelo");
		List<Parking> list = Arrays.asList(parking);
		return list.stream().filter(c -> c.getId().equals("123")).findAny().get();
		
		
	}

	public Parking create(Parking parking) {
		Parking parking2 = new Parking();
		parking2 = parking;
		return parking2;
	}

}
