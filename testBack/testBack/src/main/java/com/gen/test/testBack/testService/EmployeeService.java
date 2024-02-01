package com.gen.test.testBack.testService;

import com.gen.test.testBack.testDomain.Employee;
import com.gen.test.testBack.testDomain.Test;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee dto);

    List<Employee> getAllEmployeeData();

    Employee updateEmployeeData(String id,Employee employeeDomain);

    Employee getOneTestData(String id);

    void deleteEmployee(String id);
}
