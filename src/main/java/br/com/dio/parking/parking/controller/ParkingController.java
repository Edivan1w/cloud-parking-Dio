package br.com.dio.parking.parking.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.parking.parking.dto.ParkingCrateDto;
import br.com.dio.parking.parking.dto.ParkingDto;
import br.com.dio.parking.parking.exeception.ParkingNotFounfException;
import br.com.dio.parking.parking.mapper.ParkingMapper;
import br.com.dio.parking.parking.model.Parking;
import br.com.dio.parking.parking.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	private final ParkingService parkingService;
	private final ParkingMapper mapper;
	
	public ParkingController(ParkingMapper mapper, ParkingService parkingService) {
		this.mapper = mapper;
		this.parkingService = parkingService;
	}
	
	@GetMapping
	public ResponseEntity<List<ParkingDto>> findAll(){
		return ResponseEntity.ok(mapper.parkingToList(parkingService.findAll()));
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParkingDto> findById(@PathVariable Long id){
		return ResponseEntity.ok(mapper.parkingDto(parkingService.findById(id)));
		}

	@PostMapping
	public ResponseEntity<ParkingDto> create(@RequestBody ParkingCrateDto dto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(mapper.parkingDto(parkingService.create(mapper.createToParking(dto))));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		this.findById(id);
		parkingService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ParkingDto> update(@PathVariable Long id, @RequestBody ParkingCrateDto crateDto){
		this.findById(id);
		Parking parking = mapper.createToParking(crateDto);
		return ResponseEntity.ok( mapper.parkingDto(parkingService.update(id, parking)));
	}
	
	@PutMapping("/exit/{id}")
	public ResponseEntity<ParkingDto> exit(@PathVariable Long id){
		this.findById(id);
		 return ResponseEntity
				 .ok(mapper.parkingDto(parkingService
						 .exit(parkingService.findById(id))));
	} 
	
	
}
