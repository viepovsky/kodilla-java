package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {
    List<Book> listBooksWithCondition(String titleFragment); // lista ksiazek zaczynajacych sie od danego fragmentu tytulu

    List<Book> listBooksInHandsOf(LibraryUser libraryUser); // lista ksiazek pozyczonych przez libraryUser

    boolean rentABook(LibraryUser libraryUser, Book book); // proba wypozyczenia, zwraca true jesli mozna wypozyczyc lub false jesli nie

    int returnBooks(LibraryUser libraryUser); //zwraca wszystkie ksiazki do biblioteki, zwraca liczbe zwroconych ksiazek
}
