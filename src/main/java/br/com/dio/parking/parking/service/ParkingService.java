package br.com.dio.parking.parking.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.dio.parking.parking.dto.ParkingDto;
import br.com.dio.parking.parking.exeception.ParkingNotFounfException;
import br.com.dio.parking.parking.model.Parking;
import br.com.dio.parking.parking.repositories.ParkingRepository;
import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;

@Service
public class ParkingService {
	
	private final ParkingRepository parkingRepository;
	
	public ParkingService(ParkingRepository parkingRepository) {
		this.parkingRepository = parkingRepository;
	}
	

	
	public List<Parking> findAll(){
		return parkingRepository.findAll();
	}
	
	public Parking findById(Long id) {
		return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFounfException(id));
}

	public Parking create(Parking parking) {
		parking.setEntryDate(LocalDateTime.now());
		parkingRepository.save(parking);
		return parking;
	}
	
	public void delete(Long id) {
		this.findById(id);
		parkingRepository.deleteById(id);
	}

	public Parking update(Long id, Parking form) {
		Parking parking = this.findById(id);
		parking.setModel(form.getModel());
		parking.setColor(form.getColor());
        parking.setState(form.getState());
		return parking;
	}
	@Transactional
	public Parking exit(Parking parking) {
		 parking.setBill(ParkingCheckOut.getBill(parking));
		 return parking;
	}

}
