package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public class Library extends Prototype<Library>{
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Library shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }
    public Library deepClone() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for(Book books : books){
            clonedLibrary.books.add(books);
        }
        return clonedLibrary;
    }
    public void getAllBooks() {
        for (Book book : books){
            System.out.println(book);
        }
    }
    public Set<Book> getBooks() {
        return books;
    }
}
