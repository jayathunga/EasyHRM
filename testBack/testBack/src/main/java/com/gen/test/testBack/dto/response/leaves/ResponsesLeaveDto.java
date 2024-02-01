package com.gen.test.testBack.dto.response.leaves;

import com.gen.test.testBack.dto.response.ResponseTestDto;

import java.util.List;

public class ResponsesLeaveDto {

    private List<ResponseLeaveDto> leaveDtoList;

    public List<ResponseLeaveDto> getLeaveDtoList() {
        return leaveDtoList;
    }

    public void setLeaveDtoList(List<ResponseLeaveDto> leaveDtoList) {
        this.leaveDtoList = leaveDtoList;
    }
}
