package edu.sdccd.cisc191.springjpajavafxdemo.repositories;

import edu.sdccd.cisc191.springjpajavafxdemo.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, String> {
    List<Vehicle> findByManufacturerName(String manufacturerName);
}
