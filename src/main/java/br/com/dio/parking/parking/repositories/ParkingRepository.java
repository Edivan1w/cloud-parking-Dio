package br.com.dio.parking.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dio.parking.parking.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long>  {

}
