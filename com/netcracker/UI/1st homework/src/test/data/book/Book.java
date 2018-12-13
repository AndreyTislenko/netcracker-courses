package test.data.book;

import test.data.author.Author;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Book {
    private String name;
    private Author[] authors;
    private Date date;
    private double rating;
    private BigDecimal cost;
    private int amountOfBooks;
    private String description;
    private String publishingHouse;
    private int amountOfPages;

    public Book(String name) {
        this.name = name;
    }
    public Book(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }
    public Book(String name, Author[] authors) {
        this.name = name;
        this.authors = new Author[authors.length];
    }
    public Book(String name, Author[] authors, BigDecimal cost) {
        this.name = name;
        this.authors = authors;
        this.cost = cost;
    }
    public Book(String name, Author[] authors, Date date) {
        this.name = name;
        this.authors = authors;
        this.date = date;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public Author[] getAuthors() {
        return authors;
    }
    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    public int getAmountOfBooks() {
        return amountOfBooks;
    }
    public void setAmountOfBooks(int amountOfBooks) {
        this.amountOfBooks = amountOfBooks;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPublishingHouse() {
        return publishingHouse;
    }
    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
    public int getAmountOfPages() {
        return amountOfPages;
    }
    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return amountOfPages == book.amountOfPages &&
                Double.compare(book.rating, rating) == 0 &&
                Objects.equals(name, book.name) &&
                Arrays.equals(authors, book.authors) &&
                Objects.equals(date, book.date) &&
                Objects.equals(description, book.description) &&
                Objects.equals(publishingHouse, book.publishingHouse) &&
                Objects.equals(cost, book.cost);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, date, description, publishingHouse, amountOfPages, rating, cost);
        result = 31 * result + Arrays.hashCode(authors);
        return result;
    }
}
