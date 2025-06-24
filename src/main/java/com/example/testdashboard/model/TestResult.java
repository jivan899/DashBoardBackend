package com.example.testdashboard.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "test_results")
public class TestResult {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_result_seq")
    @SequenceGenerator(name = "test_result_seq", sequenceName = "test_result_seq", allocationSize = 1)
    private Long id;
    
    @Column(name = "test_run_id", nullable = false)
    private String testRunId;
    
    @Column(name = "test_case_id", nullable = false)
    private String testCaseId;
    
    @Column(nullable = false)
    private String status;  // "PASS" or "FAIL"
    
    @Column(name = "execution_time")
    private Long executionTime;  // in milliseconds
    
    @Column(name = "run_date")
    private Instant runDate;
    
    public TestResult() {}
    
    public TestResult(String testRunId, String testCaseId, String status, Long executionTime, Instant runDate) {
        this.testRunId = testRunId;
        this.testCaseId = testCaseId;
        this.status = status;
        this.executionTime = executionTime;
        this.runDate = runDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTestRunId() { return testRunId; }
    public void setTestRunId(String testRunId) { this.testRunId = testRunId; }
    public String getTestCaseId() { return testCaseId; }
    public void setTestCaseId(String testCaseId) { this.testCaseId = testCaseId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Long getExecutionTime() { return executionTime; }
    public void setExecutionTime(Long executionTime) { this.executionTime = executionTime; }
    public Instant getRunDate() { return runDate; }
    public void setRunDate(Instant runDate) { this.runDate = runDate; }
}
