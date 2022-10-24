package com.kodilla.stream.person;

public class StreamMain {
    public static void main(String[] args) {
        People.getList().stream()
                .forEach(System.out::println);
        System.out.println("------");
        People.getList().stream()
                .map(a -> a.toUpperCase())
                .forEach(System.out::println);
        System.out.println("------");
        People.getList().stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.println(s));
        System.out.println("------");
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(s -> System.out.println(s));
        System.out.println("------");
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);
    }
}
