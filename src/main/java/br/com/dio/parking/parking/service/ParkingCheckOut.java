package br.com.dio.parking.parking.service;

import java.time.LocalDate;

import br.com.dio.parking.parking.model.Parking;

public class ParkingCheckOut {

	public static Double getBill(Parking parking) {
		return getBill(parking.getEntryDate(), parking.getExitDate());
	}

	private static Double getBill(LocalDate entryDate, LocalDate exitDate) {
		return null;
	}
}
