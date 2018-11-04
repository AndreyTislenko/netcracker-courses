package Books.Authors.Graphomans;

import Books.Authors.Author;

import java.util.Objects;

public class Graphoman extends Author {
    private String talent;
    public Graphoman(String name, String email, char gender){
        super(name, email, gender);
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent;
    }
}