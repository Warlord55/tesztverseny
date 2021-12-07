package hu.testathlon.model.domain;

public class TestResult {

    private final String id;
    private final String result;

    public TestResult(String id, String result) {
        this.id = id;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public String getResult() {
        return result;
    }
}
