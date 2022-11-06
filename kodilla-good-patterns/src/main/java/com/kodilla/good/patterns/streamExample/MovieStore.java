package com.kodilla.good.patterns.streamExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStore {
    public Map<String, List<String>> getMovies() {
        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        return booksTitlesWithTranslations;
    }

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> moviesMap;
        moviesMap = movieStore.getMovies();
        moviesMap.entrySet().stream()
                .map(n -> n.getValue())
                .map(Object::toString)
                .map(n -> n.replace("[",""))
                .map(n -> n.replace("]","!"))
                .map(n -> n.replace(", ","!"))
                .map(n -> n.replace("h!","h"))
                .forEach(System.out::print);
        System.out.println("\n");
        String text = moviesMap.entrySet().stream()
                .map(n -> n.getValue())
                .map(Object::toString)
                .map(n -> n.replace(", ","!"))
                .map(n -> n.replace("[",""))
                .map(n -> n.replace("]",""))
                .collect(Collectors.joining("!"));
        System.out.println(text);
        System.out.print("\n");

        String text1 = moviesMap.entrySet().stream()
                .flatMap(n -> n.getValue().stream())
                .collect(Collectors.joining("!"));
        System.out.println(text1);
    }
}
