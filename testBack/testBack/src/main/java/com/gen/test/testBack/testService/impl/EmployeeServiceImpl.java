package com.gen.test.testBack.testService.impl;

import com.gen.test.testBack.testDomain.Employee;
import com.gen.test.testBack.testDomain.Test;
import com.gen.test.testBack.testRepository.EmployeeRepo;
import com.gen.test.testBack.testService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployee(Employee dto) {
        return employeeRepo.save(dto);
    }

    @Override
    public List<Employee> getAllEmployeeData() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee updateEmployeeData(String id, Employee employeeDomain) {
        Employee existingDomain=employeeRepo.findById(id).orElse(null);
        if(existingDomain!=null){
            existingDomain.merge(employeeDomain);
        }
        return employeeRepo.save(existingDomain);
    }

    @Override
    public Employee getOneTestData(String id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(String id) {
        try {
            employeeRepo.deleteById(id);

        }catch (Exception ex){
            System.out.println(ex);
        }

    }
}
