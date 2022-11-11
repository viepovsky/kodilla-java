package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {
    @Test
    void testGetBooks() {
        //Given
        LocalDate date = LocalDate.of(2022, 1, 1);
        Library library1 = new Library("Library 1");
        Book book = new Book("Book0", "Author0", date);
        library1.getBooks().add(book);
        for (int i = 1; i < 10; i++) {
            library1.getBooks().add(new Book("Book" + i, "Author" + i, date));
        }
        //When
        Library library2 = null;
        try {
            library2 = library1.deepClone();
            library2.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        library2.getBooks().remove(book);
        library1.getAllBooks();
        System.out.println("--------");
        library2.getAllBooks();
        //Then
        assertEquals(10, library1.getBooks().size());
        assertEquals(9, library2.getBooks().size());
    }
}
