package com.saravana.quizapp.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {
    private Integer id;
    private String questionText;
    private ArrayList<String> options;
    private String correctAnswer;

    public Question(Integer id, String questionText, ArrayList<String> options, String correctAnswer) {
        this.id = id;
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public Question() {
        this.options = new ArrayList<>();
    }

    @Override
    public String toString() {
        return ("ID: " + id +
                "\nQuestion: " + questionText +
                "\nOptions: " + options +
                "\nCorrect Answer: " + correctAnswer);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    // Helper method to get options as a comma-separated string
    public String getOptionsAsString() {
        return String.join(",", options);
    }

    // Helper method to set options from a comma-separated string
    public void setOptionsFromString(String optionsString) {
        this.options = new ArrayList<>(Arrays.asList(optionsString.split(",")));
    }
}
