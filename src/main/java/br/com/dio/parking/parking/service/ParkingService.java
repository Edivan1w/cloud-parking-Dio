package br.com.dio.parking.parking.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.dio.parking.parking.dto.ParkingDto;
import br.com.dio.parking.parking.model.Parking;

@Service
public class ParkingService {
	
	private List<Parking> list = new ArrayList<Parking>();
	
	public List<Parking> findAll(){
		Parking parking = new Parking();
		parking.setModel("strada");
		parking.setColor("vermelho");
		list.add(parking);
		return list;
	}
	
	public Optional<Parking> findById(String id) {
		
		return list.stream().filter(c -> c.getId().equals(id)).findAny();
}

	public Parking create(Parking parking) {
		list.add(parking);
		return parking;
	}
	
	public void delete(String id) {
		if(this.findById(id).isPresent()) {
			list.remove(this.findById(id).get());
		}
		
	}

	public Parking update(Parking parking) {
		if(list.contains(parking)) {
			
			list.add(list.indexOf(parking)
					, parking);
		}
		return parking;
	}

}
