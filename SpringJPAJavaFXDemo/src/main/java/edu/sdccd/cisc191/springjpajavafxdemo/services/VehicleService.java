package edu.sdccd.cisc191.springjpajavafxdemo.services;

import edu.sdccd.cisc191.springjpajavafxdemo.model.Option;
import edu.sdccd.cisc191.springjpajavafxdemo.model.Vehicle;
import edu.sdccd.cisc191.springjpajavafxdemo.repositories.OptionRepository;
import edu.sdccd.cisc191.springjpajavafxdemo.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    OptionRepository optionRepository;

    public List<Vehicle> findAll() { return (List<Vehicle>) vehicleRepository.findAll(); }

    public Option save(Option option) {
        return optionRepository.save(option);
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
