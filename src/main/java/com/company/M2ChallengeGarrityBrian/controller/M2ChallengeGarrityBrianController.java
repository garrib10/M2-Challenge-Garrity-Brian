package com.company.M2ChallengeGarrityBrian.controller;

import com.company.M2ChallengeGarrityBrian.models.Answer;
import com.company.M2ChallengeGarrityBrian.models.Quote;
import com.company.M2ChallengeGarrityBrian.models.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class M2ChallengeGarrityBrianController {
    Random rand = new Random();

    private static List<Quote> quote = new ArrayList<>(Arrays.asList(
            new Quote(1, "Brian", "I need some coffee"))

    );

    private static List<Word> word = new ArrayList<>(Arrays.asList(
            new Word(1, "java", "coffee")
    ));

    private static List<Answer> answer = new ArrayList<>(Arrays.asList(
            new Answer(1,"Try Again")

    ));


    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote getQuote() {

        int randomQuoteIndex = rand.nextInt(quote.size());
        Quote selectedQuote = quote.get(randomQuoteIndex);
        return selectedQuote;

    }


    @RequestMapping(value = "/word", method = RequestMethod.GET)
   @ResponseStatus(HttpStatus.OK)
   public Word getWord(){
        int randomWordIndex = rand.nextInt(word.size());
        Word selectedWord = word.get(randomWordIndex);
        return selectedWord;

    }
//    @RequestMapping(value = "/magic", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public Answer getAnswer(@RequestBody String question){
//        int randomAnswerIndex = rand.nextInt(answer.size());
//        Answer selectedAnswer = answer.get(randomAnswerIndex);
//
//        selectedAnswer.setQuestion(question);
//        return selectedAnswer;

     }

