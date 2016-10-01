package com.example;

import java.util.Random;

public class Joker {

    private String[] jokes = {"Two bytes meet.  The first byte asks, \"Are you ill?\"  \n" +
            "The second byte replies, \"No, just feeling a bit off.\"",
            "Eight bytes walk into a bar.  The bartender asks, \"Can I get you anything?\"\n" +
                    "\n" +
                    "\"Yeah,\" reply the bytes.  \"Make s a double.\"",
            "How many programmers does it take to change a light bulb?\n" +
                    "None – It's a hardware problem",
            "Why do programmers always mix up Halloween and Christmas? \n" +
                    "Because Oct 31 equals Dec 25.",
            "There are only 10 kinds of people in this world: those who know binary and those who don't.",
            "\"Knock, knock.\"\n" +
                    "\"Who's there?\"\n" +
                    "very long pause...\n" +
                    "\"Java.\""
    };
    private Random random;

    public Joker() {
        random = new Random();
    }

    public String tellRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }

}
