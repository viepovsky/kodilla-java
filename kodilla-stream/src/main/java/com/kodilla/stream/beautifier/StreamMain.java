package com.kodilla.stream.beautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("I'm here", a -> "ABC " + a + " ABC");
        poemBeautifier.beautify("I'm here", a -> a.toUpperCase());
        poemBeautifier.beautify("I'M HERE", a -> a.toLowerCase());
        poemBeautifier.beautify("I'm here", a -> " " + a + " :aBc: " + a);
    }
}
