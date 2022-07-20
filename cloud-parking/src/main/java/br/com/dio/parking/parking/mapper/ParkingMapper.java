package br.com.dio.parking.parking.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.dio.parking.parking.dto.ParkingDto;
import br.com.dio.parking.parking.model.Parking;

@Component
public class ParkingMapper {
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	
	public ParkingDto parkingDto(Parking parking) {
		return MODEL_MAPPER.map(parking, ParkingDto.class);
	}
	
	public List<ParkingDto> parkingToList(List<Parking> parkings){
		return parkings.stream().map(this::parkingDto).collect(Collectors.toList());
		
	}
}
