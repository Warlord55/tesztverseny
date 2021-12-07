package hu.testathlon.model.controller;

import hu.testathlon.model.domain.TestResult;
import hu.testathlon.model.domain.TestValidator;

import java.util.List;

public class TestService {

    private final TestValidator testValidator;
    private final List<TestResult> testResults;

    public TestService(TestValidator testValidator, List<TestResult> testResults) {
        this.testValidator = testValidator;
        this.testResults = testResults;
    }

    public int getCompetitorNumber() {
        return testResults.size();
    }
}
