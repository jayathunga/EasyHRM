package com.gen.test.testBack.transformer;

import com.gen.test.testBack.dto.request.RequestTestDto;
import com.gen.test.testBack.dto.request.employee.RequestEmployeeDto;
import com.gen.test.testBack.dto.response.ResponseTestDto;
import com.gen.test.testBack.dto.response.employee.ResponseEmployeeDto;
import com.gen.test.testBack.testDomain.Employee;
import com.gen.test.testBack.testDomain.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTransformer {

    private EmployeeTransformer(){}

    public static Employee requestEmployeeToDomain(RequestEmployeeDto requestEmployeeDto) {
        Employee target = new Employee();
        BeanUtils.copyProperties(requestEmployeeDto, target);
        return target;
    }

    public static ResponseEmployeeDto DomainToResponse(Employee employee) {
        ResponseEmployeeDto target = new ResponseEmployeeDto();
        BeanUtils.copyProperties(employee, target);
        return target;
    }

    public static List<ResponseEmployeeDto> DomainToResponseList(List<Employee> employeeList) {
        List<ResponseEmployeeDto> targetList = new ArrayList<>();
        for (Employee employeeDomain : employeeList) {
            ResponseEmployeeDto employeeResponse = DomainToResponse(employeeDomain);
            targetList.add(employeeResponse);
        }
        return targetList;

    }

    public static Employee updateRequestToDomain(RequestEmployeeDto requestEmployeeDto){
        Employee target=new Employee();
        target.setName(requestEmployeeDto.getName());
        target.setPosition(requestEmployeeDto.getPosition());
        target.setAddress(requestEmployeeDto.getAddress());
        target.setAge(requestEmployeeDto.getAge());
        target.setSalary(requestEmployeeDto.getSalary());

        return target;
    }
}
