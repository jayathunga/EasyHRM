package com.gen.test.testBack.testService.impl;

import com.gen.test.testBack.testDomain.Test;
import com.gen.test.testBack.testRepository.TestRepo;
import com.gen.test.testBack.testService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepo testRepo;

    @Override
    public Test createTest(Test dto) {
       return testRepo.save(dto);

    }

    @Override
    public Test getOneTestData(String id) {
        return testRepo.findById(id).orElse(null);
    }

    @Override
    public List<Test> getAllTestData() {
        return testRepo.findAll();

    }

    @Override
    public Test updateTestData(String id, Test testDomain) {
      Test existingDomain=testRepo.findById(id).orElse(null);
      if(existingDomain!=null){
          existingDomain.merge(testDomain);
      }
      return testRepo.save(existingDomain);
    }

    @Override
    public void deleteTest(String id) {
        try {
            testRepo.deleteById(id);
        }catch (Exception ex){
            System.out.println(ex);
        }

    }
}
