package de.julian.models;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book> {

    private int bookID;
    private String title;
    private String author;
    private int isbn;

    public Book(int bookID, String title, String author, int isbn) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getISBN() {
        return isbn;
    }

    public void setISBN(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookID " + bookID + ", " + title + ", " + author + ", " + isbn;
    }

    // equals() und hashCode() have be overriden for HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID, title, author, isbn);
    }

    // compareTo ist nicht die richtige Vergleichsmethode für uns, da es Strings lexicografisch vergleich
    @Override
    public int compareTo(Book o) {
        // this - that
        //      >       >0 positiv
        //      <       <0 negativ
        //      =       =0
        return Integer.compare(this.isbn, o.isbn) + this.title.compareTo(o.title) + this.author.compareTo(o.author);
    }
}

/*class AscendingSorter<B extends Comparable<? super B>> implements Comparator<B> {
    @Override
    public int compare(B b1, B b2) {
        return b1.compareTo(b2);
    }
}*/

class ISBNSorter implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        return Integer.compare(b1.getISBN(), b2.getISBN());
    }
}





