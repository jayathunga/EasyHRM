package com.gen.test.testBack.testController.employee;

import com.gen.test.testBack.dto.request.RequestTestDto;
import com.gen.test.testBack.dto.request.employee.RequestEmployeeDto;
import com.gen.test.testBack.dto.response.ResponseTestDto;
import com.gen.test.testBack.dto.response.ResponsesTestDto;
import com.gen.test.testBack.dto.response.employee.ResponseEmployeeDto;
import com.gen.test.testBack.dto.response.employee.ResponsesEmployeeDto;
import com.gen.test.testBack.testDomain.Employee;
import com.gen.test.testBack.testDomain.Test;
import com.gen.test.testBack.testService.EmployeeService;
import com.gen.test.testBack.transformer.EmployeeTransformer;
import com.gen.test.testBack.transformer.TestTransformer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Data
@RequestMapping(value = "/api/v1/emp",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public @ResponseBody ResponseEmployeeDto createEmployee(@RequestBody RequestEmployeeDto requestEmployeeDto){
        Employee employeeDomain= EmployeeTransformer.requestEmployeeToDomain(requestEmployeeDto);
        Employee createdEmployeeDomain=employeeService.createEmployee(employeeDomain);
        return EmployeeTransformer.DomainToResponse(createdEmployeeDomain);
    }

    @GetMapping("/getAllEmployee")
    public @ResponseBody ResponsesEmployeeDto getAllEmployeeData(){
        List<Employee> employeeDomainList=employeeService.getAllEmployeeData();
        List<ResponseEmployeeDto>response=EmployeeTransformer.DomainToResponseList(employeeDomainList);
        ResponsesEmployeeDto responseList=new ResponsesEmployeeDto();
        responseList.setEmployeeDtoList(response);
        return responseList;
    }

    @PutMapping("/updateEmp/{id}")
    public @ResponseBody ResponseEmployeeDto updateTestData(@PathVariable String id,@RequestBody RequestEmployeeDto requestEmployeeDto){
        Employee employeeDomain=EmployeeTransformer.updateRequestToDomain(requestEmployeeDto);
        Employee updatedTestDomain=employeeService.updateEmployeeData(id,employeeDomain);
        return EmployeeTransformer.DomainToResponse(updatedTestDomain);

    }

    @GetMapping("/getOne/{id}")
    public @ResponseBody ResponseEmployeeDto getTestById(@PathVariable String id){
        Employee employee=employeeService.getOneTestData(id);
        ResponseEmployeeDto response=EmployeeTransformer.DomainToResponse(employee);
        return response;

    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);

    }
}
