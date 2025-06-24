package com.example.testdashboard.repository;

import com.example.testdashboard.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.Instant;
import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    
    List<TestResult> findByTestRunId(String testRunId);
    List<TestResult> findByTestCaseId(String testCaseId);
    List<TestResult> findByStatus(String status);
    List<TestResult> findByRunDateBetween(Instant startDate, Instant endDate);
}
