package com.gen.test.testBack.testService;

import com.gen.test.testBack.testDomain.Test;

import java.util.List;

public interface TestService {

    Test createTest(Test dto);

    Test getOneTestData(String id);

    List<Test> getAllTestData();

    Test updateTestData(String id,Test testDomain);

    void deleteTest(String id);
}
