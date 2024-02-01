package com.gen.test.testBack.transformer;

import com.gen.test.testBack.dto.request.employee.RequestEmployeeDto;
import com.gen.test.testBack.dto.request.leaves.RequestLeaveDto;
import com.gen.test.testBack.dto.response.employee.ResponseEmployeeDto;
import com.gen.test.testBack.dto.response.leaves.ResponseLeaveDto;
import com.gen.test.testBack.testDomain.Employee;
import com.gen.test.testBack.testDomain.Leave;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class LeaveTransformer {

    private LeaveTransformer(){
    }

    public static Leave requestLeaveToDomain(RequestLeaveDto requestLeaveDto) {
        Leave target = new Leave();
        BeanUtils.copyProperties(requestLeaveDto, target);
        return target;
    }

    public static ResponseLeaveDto DomainToResponse(Leave leave) {
        ResponseLeaveDto target = new ResponseLeaveDto();
        BeanUtils.copyProperties(leave, target);
        return target;
    }

    public static List<ResponseLeaveDto> DomainToResponseList(List<Leave> leaveList) {
        List<ResponseLeaveDto> targetList = new ArrayList<>();
        for (Leave leaveDomain : leaveList) {
            ResponseLeaveDto leaveResponse = DomainToResponse(leaveDomain);
            targetList.add(leaveResponse);
        }
        return targetList;

    }

    public static Leave updateRequestToDomain(RequestLeaveDto requestLeaveDto){
        Leave target=new Leave();
        target.setDate(requestLeaveDto.getDate());
        target.setLeaveCount(requestLeaveDto.getLeaveCount());
        target.setLeaveType(requestLeaveDto.getLeaveType());

        return target;
    }
}
