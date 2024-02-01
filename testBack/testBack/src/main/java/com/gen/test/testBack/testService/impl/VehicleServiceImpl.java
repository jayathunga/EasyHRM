package com.gen.test.testBack.testService.impl;

import com.gen.test.testBack.testDomain.Vehicle;
import com.gen.test.testBack.testRepository.VehicleRepo;
import com.gen.test.testBack.testService.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }
}
