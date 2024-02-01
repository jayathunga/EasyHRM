package com.gen.test.testBack.transformer;

import com.gen.test.testBack.dto.request.RequestTestDto;
import com.gen.test.testBack.dto.request.RequestVehicleDto;
import com.gen.test.testBack.dto.response.ResponseTestDto;
import com.gen.test.testBack.dto.response.ResponseVehicleDto;
import com.gen.test.testBack.testDomain.Test;
import com.gen.test.testBack.testDomain.Vehicle;
import org.springframework.beans.BeanUtils;

public final class VehicleTransformer {

    private VehicleTransformer(){}

    public static Vehicle requestVehicleToDomain(RequestVehicleDto requestVehicleDto) {
        Vehicle target = new Vehicle();
        BeanUtils.copyProperties(requestVehicleDto, target);
        return target;
    }

    public static ResponseVehicleDto DomainToResponse(Vehicle vehicle) {
        ResponseVehicleDto target = new ResponseVehicleDto();
        BeanUtils.copyProperties(vehicle, target);
        return target;
    }
}
