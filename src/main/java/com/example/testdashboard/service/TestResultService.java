package com.example.testdashboard.service;

import com.example.testdashboard.model.TestResult;
import com.example.testdashboard.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class TestResultService {
    
    @Autowired
    private TestResultRepository repository;
    
    public TestResult saveTestResult(TestResult testResult) {
        return repository.save(testResult);
    }
    
    public List<TestResult> getTestResults(
            String testRunId, 
            String testCaseId, 
            String status, 
            Instant startDate, 
            Instant endDate) {
        
        if (testRunId != null) {
            return repository.findByTestRunId(testRunId);
        } else if (testCaseId != null) {
            return repository.findByTestCaseId(testCaseId);
        } else if (status != null) {
            return repository.findByStatus(status);
        } else if (startDate != null && endDate != null) {
            return repository.findByRunDateBetween(startDate, endDate);
        } else {
            return repository.findAll();
        }
    }
}
