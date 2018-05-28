package com.example.jokeslib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jokes {

    private List<String> jokes;

    public Jokes() {
        jokes = new ArrayList<>();
        jokes.add("a");
        jokes.add("b");
        jokes.add("c");
    }

    public String getJoke() {
        return jokes.get(new Random().nextInt(jokes.size()));
    }
}
