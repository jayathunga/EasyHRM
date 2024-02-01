package com.gen.test.testBack.testController;

import com.gen.test.testBack.dto.request.RequestTestDto;
import com.gen.test.testBack.dto.request.RequestVehicleDto;
import com.gen.test.testBack.dto.response.ResponseTestDto;
import com.gen.test.testBack.dto.response.ResponseVehicleDto;
import com.gen.test.testBack.testDomain.Test;
import com.gen.test.testBack.testDomain.Vehicle;
import com.gen.test.testBack.testService.TestService;
import com.gen.test.testBack.testService.VehicleService;
import com.gen.test.testBack.transformer.TestTransformer;
import com.gen.test.testBack.transformer.VehicleTransformer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@Data
@RequestMapping(value = "api/v1/vehicle",produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private TestService testService;

    @GetMapping("/getOne/{id}")
    public void getTestById(@PathVariable String id){
        Test testDomain=testService.getOneTestData(id);
        ResponseTestDto response=TestTransformer.DomainToResponse(testDomain);
        String idVal=response.getId();
        Vehicle vehicle=new Vehicle();



    }
    @PostMapping("/create")
    public @ResponseBody ResponseVehicleDto createTest(@RequestBody RequestVehicleDto requestVehicleDto){
        Vehicle vehicle = VehicleTransformer.requestVehicleToDomain(requestVehicleDto);
        Vehicle createdVehicleDomain = vehicleService.createVehicle(vehicle);
        return VehicleTransformer.DomainToResponse(createdVehicleDomain);
    }
}
