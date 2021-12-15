package hu.testathlon.model.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestValidator {

    private static final int[] POINTS = {3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 6};

    private final String answer;

    public TestValidator(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String checkResult(String competitorAnswers) {
        return IntStream.range(0, answer.length())
                .mapToObj(i -> checkAnswer(competitorAnswers, i))
                .collect(Collectors.joining());
    }



    private String checkAnswer(String competitorAnswers, int i) {
        return isCorrect(competitorAnswers, i) ? "+" : " ";
    }

    private int getScore(String competitorAnswers, int i){
        return isCorrect(competitorAnswers, i) ? POINTS[i] : 0;
    }

    public boolean isCorrect(String competitorAnswers, int i) {
        return answer.charAt(i) == competitorAnswers.charAt(i);
    }


}
