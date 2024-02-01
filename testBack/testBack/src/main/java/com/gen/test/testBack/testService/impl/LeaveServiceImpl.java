package com.gen.test.testBack.testService.impl;

import com.gen.test.testBack.testDomain.Employee;
import com.gen.test.testBack.testDomain.Leave;
import com.gen.test.testBack.testRepository.EmployeeRepo;
import com.gen.test.testBack.testRepository.LeaveRepo;
import com.gen.test.testBack.testService.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepo leaveRepo;

    @Override
    public Leave createLeave(Leave dto) {
        return leaveRepo.save(dto);
    }

    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepo.findAll();
    }

    @Override
    public Leave getOneLeave(String id) {
        return leaveRepo.findById(id).orElse(null);
    }

    @Override
    public Leave updateLeave(String id, Leave leaveDomain) {
        Leave existingDomain=leaveRepo.findById(id).orElse(null);
        if(existingDomain!=null){
            existingDomain.merge(leaveDomain);
        }
        return leaveRepo.save(existingDomain);
    }
}
