package hu.testathlon.model.domain;

import hu.testathlon.model.controller.TestService;
import hu.testathlon.model.service.Console;
import hu.testathlon.model.service.DataApi;
import hu.testathlon.model.service.DataParser;
import hu.testathlon.model.service.FileReader;

import java.util.Scanner;

public class App {

    private final TestService testService;
    private final Console console;


    private App() {
        DataApi dataApi = new DataApi("valaszok.txt", new FileReader(), new DataParser());
        testService = new TestService(new TestValidator(dataApi.getAnswers()), dataApi.getTestResults());
        console = new Console(new Scanner(System.in));
    }

    public static void main(String[] args) {
        new App().run();

    }

    private void run() {
        System.out.println("1. feladat: Az adatok beolvasása ");
        System.out.println("2. feladat: ");
        int competitorNumber = testService.getCompetitorNumber();
        System.out.println("A vetélkedőn: " + competitorNumber + " Versenyző indult ");
        System.out.print("3. feladat: A versenyző azonositója = ");
        String id = console.read();
        System.out.println(testService.getAnswersById(id) + "\t(A versenyző válasza)");
        System.out.println("4. feladat");
        System.out.println(testService.getCorrectAnswer() + "\t(a helyes megoldás)");
        System.out.println(testService.getCheckResultById(id) + "\t(a versenyző helyes válaszai)");
        System.out.print("5. feladat: A feladat sorszáma = ");
        int taskId = console.readInt() - 1;
        long countAnswersByTasks = testService.countAnswersByTasks(taskId);
        System.out.printf("A feladatra %d fő, a versenyzők %5.2f%%-a adott helyes választ.",
                countAnswersByTasks, countAnswersByTasks * 100.0 / competitorNumber);

    }
}