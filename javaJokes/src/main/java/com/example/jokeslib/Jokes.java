package com.example.jokeslib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jokes {

    private List<String> jokes;

    public Jokes() {
        jokes = new ArrayList<>();
        jokes.add("Q. How did the programmer die in the shower?\n" +
                "A. He read the shampoo bottle instructions: Lather. Rinse. Repeat.");
        jokes.add("CAPS LOCK: Preventing Login Since 1980");
        jokes.add("Q: How do you explain the movie Inception to a programmer?\n" +
                "A: Basically, when you run a VM inside another VM, inside another VM, inside another VM, everything runs real slow!");
    }

    public String getJoke() {
        return jokes.get(new Random().nextInt(jokes.size()));
    }
}
