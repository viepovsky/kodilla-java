package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("TDD: Book Directory Test Suite")
public class BookDirectoryTestSuite {
    private static int counter = 0;
    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity){
        List<Book> resultList = new ArrayList<>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title" + n,"Author" + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Starting all tests");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("End of all tests");
    }
    @BeforeEach
    public void beforeEach(){
        counter++;
        System.out.println("Starting test #" + counter);
    }
    @AfterEach
    public void afterEach(){
        System.out.println("End of test #" + counter);
    }
    @Test
    public void testListBooksWithConditionsReturnList(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        //Then
        assertEquals(4,theListOfBooks.size());
        System.out.println(theListOfBooks);
    }
    @Test
    public void testListBooksWithConditionMoreThan20(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
        //When
        List<Book> theListOf0Books = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOf15Books = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOf40Books = bookLibrary.listBooksWithCondition("FortyBooks");
        //Then
        assertEquals(0,theListOf0Books.size());
        assertEquals(15,theListOf15Books.size());
        assertEquals(0,theListOf40Books.size());
    }
    @Test
    public void testListBooksWithConditionFragmentShorterThan3(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        //Then
        assertEquals(0,theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }
    @Test
    public void testListBooksInHandsOfNoBooksWithdrawn(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Marek","Klacz","720220");
        List<Book> resultBookList = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultBookList);
        //When
        List<Book> theBookList = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        assertEquals(0,theBookList.size());
    }
    @Test
    public void testListBooksInHandsOf1BookWithdrawn(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Marek","Klacz","720220");
        List<Book> resultBookList = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultBookList);
        //When
        List<Book> theBookList = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        assertEquals(1,theBookList.size());
    }
    @Test
    public void testListBooksInHandsOf5BooksWithdrawn(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Marek","Klacz","720220");
        List<Book> resultBookList = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultBookList);
        //When
        List<Book> theBookList = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        assertEquals(5,theBookList.size());
    }
}
