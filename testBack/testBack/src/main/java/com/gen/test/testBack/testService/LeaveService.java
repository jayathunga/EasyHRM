package com.gen.test.testBack.testService;

import com.gen.test.testBack.testDomain.Employee;
import com.gen.test.testBack.testDomain.Leave;

import java.util.List;

public interface LeaveService {

    Leave createLeave(Leave dto);

    List<Leave> getAllLeaves();

    Leave getOneLeave(String id);

    Leave updateLeave(String id,Leave leaveDomain);
}
