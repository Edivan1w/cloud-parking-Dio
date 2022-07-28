package br.com.dio.parking.parking.service;


import java.time.LocalDateTime;

import br.com.dio.parking.parking.model.CalculoHoras;
import br.com.dio.parking.parking.model.Parking;

public class ParkingCheckOut {

	public static Double getBill(Parking parking) {
		parking.setExitDate(LocalDateTime.now());
		return getBill(parking.getEntryDate(), parking.getExitDate());
	}

	private static Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {
		CalculoHoras[] values = CalculoHoras.values();
		Double result = 0.0;
		for (CalculoHoras calculoHoras : values) {
			Double calcular = calculoHoras.calcular(entryDate, exitDate);
			if(calcular != null) {
				result = calcular;
			}
		}
		return result;
	}
}
