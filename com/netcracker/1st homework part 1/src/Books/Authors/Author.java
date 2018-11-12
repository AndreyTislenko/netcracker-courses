package Books.Authors;

import java.util.Objects;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author() {}
    public Author(String name, char gender) {
        this.name = name;
        this.gender = gender;
    }
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) return true;
        if (otherObj == null) return false;
        if (!(otherObj.getClass() == getClass())) return false;

        Author otherAuthor = (Author)otherObj;
        return Objects.equals(name,  otherAuthor.getName())&&
                Objects.equals(email, otherAuthor.getEmail())&&
                (gender == otherAuthor.getGender());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + name.hashCode();
        result = 31*result + (email == null ? 0 : email.hashCode());
        result = 31*result + gender;
        return  result;
    }
}

