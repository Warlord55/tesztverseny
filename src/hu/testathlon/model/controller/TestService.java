package hu.testathlon.model.controller;

import hu.testathlon.model.domain.TestResult;
import hu.testathlon.model.domain.TestValidator;

import javax.xml.transform.Result;
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

   public String getAnswersById(String id) {
        return getTestResultById(id).getResult();
   }

    public String getCorrectAnswer() {
        return testValidator.getAnswer();
    }

   private TestResult getTestResultById(String id) {
        return testResults.stream()
                .filter(testResult -> testResult.getId().equals(id))
                .findAny()
                .get();
    }
}
