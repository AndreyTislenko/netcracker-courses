package inputChecker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

    private String[] columns;
    private Pattern[] restrictions;

    public InputChecker(String[] columns) {
        this.columns = columns;
        restrictions = new Pattern[columns.length];
        setRestrictions();
    }

    public boolean checkInputForColumn(int indexOfColumn, String element) {
        if(element.isEmpty()) return true;

        Matcher matcher = restrictions[indexOfColumn].matcher(element);
        return matcher.matches();
    }

    private void setRestrictions() {
       /*
        * For book name any character is allowed.*/
        restrictions[0] = Pattern.compile(".*"); //name

       /*
        * For authors' name only alphabetical characters forming two words that can be separated by commas are allowed.*/
        restrictions[1] = Pattern.compile("\\A([a-zA-Z\\s]+,?)+(?<=[a-zA-Z])\\z"); //author(s)

       /*
        * For dates only positive integer numbers are allowed which can be followed by B.C (before christ)
        * or A.D. (anno domini).*/
        restrictions[2] = Pattern.compile("\\A\\s*\\d+\\s*(B\\.C\\.|A\\.D\\.)?\\s*\\z"); //date

       /*
        * For ratings only positive numbers less than 10.01 and having two decimal digits are allowed.*/
        restrictions[3] = Pattern.compile("\\A\\s*(10|10\\.0|10\\.00|(\\d(\\.\\d{1,2})?))\\s*\\z"); //rating

       /*
        * For prices only positive real numbers are allowed.*/
        restrictions[4] = Pattern.compile("\\A\\s*\\d+(\\.\\d+)?\\s*\\z"); //price

       /*
        * For amounts only positive integers numbers are allowed.*/
        restrictions[5] = Pattern.compile("\\A\\s*\\d+\\s*\\z"); //amount
    }

}
