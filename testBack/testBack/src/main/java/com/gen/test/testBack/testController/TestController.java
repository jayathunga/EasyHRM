package com.gen.test.testBack.testController;

import com.gen.test.testBack.dto.request.RequestTestDto;
import com.gen.test.testBack.dto.response.ResponseTestDto;
import com.gen.test.testBack.dto.response.ResponsesTestDto;
import com.gen.test.testBack.testDomain.Test;
import com.gen.test.testBack.testService.TestService;
import com.gen.test.testBack.transformer.TestTransformer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
@Data
@RequestMapping(value = "/api/v1/test",produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/create")
   public @ResponseBody ResponseTestDto createTest(@RequestBody RequestTestDto requestTestDto){
     Test testDomain= TestTransformer.requestTestToDomain(requestTestDto);
     Test createdTestDomain=testService.createTest(testDomain);
     return TestTransformer.DomainToResponse(createdTestDomain);
   }

   @GetMapping("/getOne/{id}")
   public @ResponseBody ResponseTestDto getTestById(@PathVariable String id){
     Test testDomain=testService.getOneTestData(id);
     ResponseTestDto response=TestTransformer.DomainToResponse(testDomain);
     return response;

   }

   @GetMapping("/getAllTest")
   public @ResponseBody ResponsesTestDto getAllTestData(){
       List<Test>testDomainList=testService.getAllTestData();
       List<ResponseTestDto>response=TestTransformer.DomainToResponseList(testDomainList);
       ResponsesTestDto responseList=new ResponsesTestDto();
       responseList.setTestDomainList(response);
       return responseList;
   }

   @PutMapping("/updateTest/{id}")
    public @ResponseBody ResponseTestDto updateTestData(@PathVariable String id,@RequestBody RequestTestDto requestTestDto){
        Test testDomain=TestTransformer.updateRequestToDomain(requestTestDto);
        Test updatedTestDomain=testService.updateTestData(id,testDomain);
        return TestTransformer.DomainToResponse(updatedTestDomain);

   }

   @DeleteMapping("/delete/{id}")
    public void deleteTest(@PathVariable String id){
        testService.deleteTest(id);
   }




}
