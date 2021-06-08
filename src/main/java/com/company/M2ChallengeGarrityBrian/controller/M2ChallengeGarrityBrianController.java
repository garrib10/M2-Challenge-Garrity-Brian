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

    /// Quotes provided by google.com and brainyquotes.com
    private static List<Quote> quote = new ArrayList<>(Arrays.asList(
            new Quote(1, "Albert Einstein", "Imagination is more important than knowledge."),
            new Quote(2, "John Lennon", " Time you enjoy wasting, was not wasted."),
            new Quote(3, "Kurt Vonnegut", "Everything was beautiful and nothing hurt."),
            new Quote(4, "Charles Bukowski", "Some people never go crazy. What truly horrible lives they must lead"),
            new Quote(5, "Kurt Cobain", "I'd rather be hated for who I am, than loved for who I am not."),
            new Quote(6, "Anthony Bourdain", "Context and memory play powerful roles in all the truly great meals in one's life."),
            new Quote(7, "Jimi Hendrix", "When the power of love overcomes the love of power the world will know peace."),
            new Quote(8, "Mark Twain", "Age is an issue of mind over matter. If you don't mind, it doesn't matter."),
            new Quote(9, "Ernest Hemingway", "But man is not made for defeat. A man can be destroyed but not defeated."),
            new Quote(10, "Charles Dickens", "It was the best of times, it was the worst of times.")

    ));
    // Used definition in google search
    private static List<Word> word = new ArrayList<>(Arrays.asList(
            new Word(1, "Java", "A high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible"),
            new Word(2, "HTML", "Hypertext Markup Language, a standardized system for tagging text files to achieve font, color, graphic, and hyperlink effects on World Wide Web pages."),
            new Word(3, "CSS", "Is a declarative language that controls how webpages look in the browser."),
            new Word(4, "JavaScript", "An object-oriented computer programming language commonly used to create interactive effects within web browsers."),
            new Word(5, "React", "Is an open-source front-end JavaScript library for building user interfaces or UI components."),
            new Word(6, "API", "A set of functions and procedures allowing the creation of applications that access the features or data of an operating system, application, or other service."),
            new Word(7, "Add", "Join (something) to something else so as to increase the size, number, or amount."),
            new Word(8, "Success", "The accomplishment of an aim or purpose."),
            new Word(9, "Failure", "Lack of Success"),
            new Word(10, "Negligence", "Failure to take proper care in doing something")
    ));
    // Used magic ball  answers from https://futureofworking.com/20-funny-magic-8-ball-sayings/
    private static List<Answer> answer = new ArrayList<>(Arrays.asList(
            new Answer(1, "Try Again"),
            new Answer(2, "Things are looking up!"),
            new Answer(3, "What is the worst that can happen"),
            new Answer(4, "Don't Count on it"),
            new Answer(5, "Very doubtful"),
            new Answer(6, "Yes, definitely")

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
    public Word getWord() {
        int randomWordIndex = rand.nextInt(word.size());
        Word selectedWord = word.get(randomWordIndex);
        return selectedWord;

    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Answer getAnswer(@RequestBody String question) {
        int randomAnswerIndex = rand.nextInt(answer.size());
        Answer selectedAnswer = answer.get(randomAnswerIndex);

        selectedAnswer.setQuestion(question);
        return selectedAnswer;

    }
}

