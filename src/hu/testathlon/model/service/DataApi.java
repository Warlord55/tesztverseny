package hu.testathlon.model.service;

import hu.testathlon.model.domain.TestResult;

import java.util.List;

public class DataApi {

    private final DataParser dataParser;

    public DataApi(String filename, FileReader fileReader, DataParser dataParser) {
        lines = fileReader.read(filename);
        this.dataParser = dataParser;

    }

    private final List<String> lines;


    public List<TestResult> getTestResults() {
        return dataParser.getResult(lines);

    }

    public String getAnswers() {
        return dataParser.getAnswers(lines);
    }
}
