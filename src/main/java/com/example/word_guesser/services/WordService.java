package com.example.word_guesser.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class WordService {

    public List<String> words;

    public WordService() {
        this.words = Arrays.asList(
                "hello",
                "goodbye",
                "testing",
                "mystery",
                "spring",
                "controller",
                "dog"
        );
    }

    public String getRandomWord() {
//        Based on list size selects a random word from words
        Random random = new Random();
        int randomIndex = random.nextInt(this.words.size()); // .nextInt adds 1 to the integer, limited by the size of words
        return this.words.get(randomIndex);
    }

}
