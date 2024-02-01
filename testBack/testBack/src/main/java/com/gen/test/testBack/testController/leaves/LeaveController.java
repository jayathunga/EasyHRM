package com.gen.test.testBack.testController.leaves;

import com.gen.test.testBack.dto.request.employee.RequestEmployeeDto;
import com.gen.test.testBack.dto.request.leaves.RequestLeaveDto;
import com.gen.test.testBack.dto.response.employee.ResponseEmployeeDto;
import com.gen.test.testBack.dto.response.employee.ResponsesEmployeeDto;
import com.gen.test.testBack.dto.response.leaves.ResponseLeaveDto;
import com.gen.test.testBack.dto.response.leaves.ResponsesLeaveDto;
import com.gen.test.testBack.testDomain.Employee;
import com.gen.test.testBack.testDomain.Leave;
import com.gen.test.testBack.testService.EmployeeService;
import com.gen.test.testBack.testService.LeaveService;
import com.gen.test.testBack.transformer.EmployeeTransformer;
import com.gen.test.testBack.transformer.LeaveTransformer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Data
@RequestMapping(value = "/api/v1/leave",produces = MediaType.APPLICATION_JSON_VALUE)
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/create")
    public @ResponseBody ResponseLeaveDto createLeave(@RequestBody RequestLeaveDto requestLeaveDto){
        Leave leaveDomain= LeaveTransformer.requestLeaveToDomain(requestLeaveDto);
        Leave createdLeaveDomain=leaveService.createLeave(leaveDomain);
        return LeaveTransformer.DomainToResponse(createdLeaveDomain);
    }

    @GetMapping("/getAllLeaves")
    public @ResponseBody ResponsesLeaveDto getAllLeaves(){
        List<Leave> leaveList=leaveService.getAllLeaves();
        List<ResponseLeaveDto>response=LeaveTransformer.DomainToResponseList(leaveList);
        ResponsesLeaveDto responseList=new ResponsesLeaveDto();
        responseList.setLeaveDtoList(response);
        return responseList;
    }

    @GetMapping("/getOne/{id}")
    public @ResponseBody ResponseLeaveDto getTestById(@PathVariable String id){
        Leave leave=leaveService.getOneLeave(id);
        ResponseLeaveDto response=LeaveTransformer.DomainToResponse(leave);
        return response;

    }

    @PutMapping("/updateLeave/{id}")
    public @ResponseBody ResponseLeaveDto updateTestData(@PathVariable String id,@RequestBody RequestLeaveDto requestLeaveDto){
        Leave leaveDomain=LeaveTransformer.updateRequestToDomain(requestLeaveDto);
        Leave updatedTestDomain=leaveService.updateLeave(id,leaveDomain);
        return LeaveTransformer.DomainToResponse(updatedTestDomain);

    }
}
