package com.example.word_guesser.models;


// This is the class that will be passed around our application
public class Reply {

    private boolean correct;
    private String wordState;
    private String message;

    public Reply(boolean correct, String wordState, String message) {
        this.correct = correct;
        this.wordState = wordState;
        this.message = message;
    }

    public Reply() {
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getWordState() {
        return wordState;
    }

    public void setWordState(String wordState) {
        this.wordState = wordState;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
