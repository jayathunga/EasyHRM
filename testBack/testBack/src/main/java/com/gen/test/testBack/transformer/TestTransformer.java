package com.gen.test.testBack.transformer;

import com.gen.test.testBack.dto.request.RequestTestDto;
import com.gen.test.testBack.dto.response.ResponseTestDto;
import com.gen.test.testBack.testDomain.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public final class TestTransformer {



    private TestTransformer() {
    }

    public static Test requestTestToDomain(RequestTestDto requestTestDto) {
        Test target = new Test();
        BeanUtils.copyProperties(requestTestDto, target);
        return target;
    }

    public static ResponseTestDto DomainToResponse(Test testDomain) {
        ResponseTestDto target = new ResponseTestDto();
        BeanUtils.copyProperties(testDomain, target);
        return target;
    }

    public static List<ResponseTestDto> DomainToResponseList(List<Test> testDomainList) {
        List<ResponseTestDto> targetList = new ArrayList<>();
        for (Test testDomain : testDomainList) {
            ResponseTestDto testResponse = DomainToResponse(testDomain);
            targetList.add(testResponse);
        }
        return targetList;

    }

    public static Test updateRequestToDomain(RequestTestDto requestTestDto){
        Test target=new Test();
        target.setName(requestTestDto.getName());
        target.setAddress(requestTestDto.getAddress());

        return target;
    }
}
