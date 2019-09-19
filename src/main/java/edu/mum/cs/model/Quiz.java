package edu.mum.cs.model;

public class Quiz {
    private static String[] questions = {
            "3, 1, 4, 1, 5", //pi
            "1, 1, 2, 3, 5", //fibancci
            "1, 4, 9, 16, 25", //squares
            "2, 3, 5, 7, 11", //primes
            "1, 2, 4, 8, 16" //powers of 2
    };
    private static int[] answers = {9, 8, 36, 13, 32};

    public String[] getQuestions() {
        return questions;
    }

    public int[] getAnswers() {
        return answers;
    }
}
