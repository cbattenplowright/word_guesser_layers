package com.example.word_guesser.controllers;

import com.example.word_guesser.models.Game;
import com.example.word_guesser.models.Guess;
import com.example.word_guesser.models.LetterList;
import com.example.word_guesser.models.Reply;
import com.example.word_guesser.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping(value = "/games")
public class GameController {

//    Tells Bean to instantiate a gameService object this is dependency injection allowing us to loosely couple the code
    @Autowired
    GameService gameService;

    @PostMapping
    public ResponseEntity<Reply> startNewGame() {
        Reply reply = gameService.startNewGame();
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Reply> getGameStatus() {
        Reply reply;
        // Check if game has started
        if (gameService.getGame() == null) {
            reply = new Reply(
                    false,
                    gameService.getCurrentWord(),
                    String.format("Game has not been started"));
        } else {
            reply = new Reply(
                    false,
                    gameService.getCurrentWord(),
                    "Game in progress.");
        }
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Reply> handleGuess(@RequestBody Guess guess) {
        Reply reply = gameService.processGuess(guess);
        // return result
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }

    @GetMapping(value = "/guessed")
    public ResponseEntity<LetterList> checkGuesses() {
        ArrayList<String> guesses = gameService.getGuessedLetters();
        LetterList letters = new LetterList(guesses);
        return new ResponseEntity<>(letters, HttpStatus.OK);
    }
}
