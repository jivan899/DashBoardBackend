package com.example.testdashboard.controller;

import com.example.testdashboard.model.TestResult;
import com.example.testdashboard.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/test-results")
public class TestResultController {
    
    @Autowired
    private TestResultService testResultService;
    
    @PostMapping
    public ResponseEntity<TestResult> saveTestResult(@RequestBody TestResult testResult) {
        TestResult savedResult = testResultService.saveTestResult(testResult);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResult);
    }
    
    @GetMapping
    public ResponseEntity<List<TestResult>> getTestResults(
            @RequestParam(required = false) String testRunId,
            @RequestParam(required = false) String testCaseId,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endDate) {
        
        List<TestResult> results = testResultService.getTestResults(
            testRunId, testCaseId, status, startDate, endDate);
        
        return ResponseEntity.ok(results);
    }
}
