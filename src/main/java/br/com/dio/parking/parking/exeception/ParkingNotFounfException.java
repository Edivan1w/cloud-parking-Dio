package br.com.dio.parking.parking.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkingNotFounfException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ParkingNotFounfException(Long id) {
		super("Parking not fount whith id: " + id);
	}

}
