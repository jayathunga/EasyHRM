package com.gen.test.testBack.dto.response.employee;

import com.gen.test.testBack.dto.response.ResponseTestDto;

import java.util.List;

public class ResponsesEmployeeDto {

    private List<ResponseEmployeeDto> employeeDtoList;

    public List<ResponseEmployeeDto> getEmployeeDtoList() {
        return employeeDtoList;
    }

    public void setEmployeeDtoList(List<ResponseEmployeeDto> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }
}
