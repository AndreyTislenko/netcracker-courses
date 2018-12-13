package test.data.author;

import java.util.Objects;

public class Author {
    private String firstName;
    private String lastName;
    private String fullName;
    private int age;
    private char gander;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        fullName = firstName + " " + lastName;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String secondName) {
        this.lastName = secondName;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getGander() {
        return gander;
    }
    public void setGander(char gander) {
        this.gander = gander;
    }

    @Override
    public String toString() {
        return  fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age &&
                gander == author.gander &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(fullName, author.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, fullName, age, gander);
    }
}
