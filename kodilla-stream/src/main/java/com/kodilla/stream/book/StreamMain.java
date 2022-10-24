package com.kodilla.stream.book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        BookDirectory bookDirectory = new BookDirectory();
        List<Book> newBookList = bookDirectory.getList().stream()
            .filter(book -> book.getYearOfPublication() > 2005)
            .collect(Collectors.toList());

        newBookList.stream()
                .forEach(System.out::println);

        Map<String, Book> resultBookMap = bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + resultBookMap.size());
        resultBookMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println("--------");
        String theResultStringOfBooks = bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
    }
}
