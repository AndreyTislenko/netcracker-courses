package Books;

import Books.Authors.Author;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty; // by default qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }
    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }
    public Author[] getAuthors() {
        return authors;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAuthorNames(){
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < authors.length; i++){
            names.append(authors[i].getName());
            if (i < authors.length - 1) names.append(", ");
        }
        return names.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) return true;
        if (otherObj == null) return false;
        if (otherObj.getClass() != getClass()) return false;

        Book otherBook = (Book)otherObj;
        return Objects.equals(name, otherBook.getName())&&
                Arrays.equals(authors, otherBook.getAuthors())&&
                (price == otherBook.getPrice())&&
                (qty == otherBook.getQty());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + name.hashCode();
        result = 31*result + Arrays.hashCode(authors);
        long price = Double.doubleToLongBits(this.price);
        result = 31*result + (int)(price^(price>>>32));
        result = 31*result + qty;
        return result;
    }
}
