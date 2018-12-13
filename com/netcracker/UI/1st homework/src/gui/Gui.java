package gui;

import gui.bookMainFrame.MainFrame;

public class Gui {

   /*
    * The main gui consists of the table, the two buttons (add and remove row buttons) and
    * the menu bar with the file option. The file option is a little bit slack-baked. E.g.
    * the new option creates new table but this new table cannot be saved automatically. The
    * only way to save it is via the save option. In other words only the default table has
    * the "save automatically" feature.
    * It should also be noted that the interface itself is somewhat clumsy. For instance,
    * the functionality intensely beseeches to add the "undo" button. Or to create close
    * button for new tabs. And the graphics itself looks pity... well I was trying to varnish
    * and frame it as good as possible, but I'm very bad at design. I simply couldn't come up
    * with better design.
    * About the code. I think it could be better. If I try to rewrite everything from the very beginning,
    * I think the code will have more concise and readable structure, because I see things now differently.
    * Also I will think about good commentaries to add. Usually I comment a lot, but in this case I was
    * overwhelmed by new technologies and by new tools to study, so I completely forgot all about it.
    */

    public Gui(){
        MainFrame mainFrame = new MainFrame("Book table");
        mainFrame.setEverything();
    }

    //Optional to read
    /* P.S.
     * How smart and versatile should our code be? We could write anything,
     * from a terribly simple function that can only pad a number to be three
     * characters wide to a complicated generalized number-formatting system
     * that handles fractional numbers, negative numbers, alignment of decimal dots,
     * padding with different characters, and so on.
     *
     * A useful principle is to not add cleverness unless you are absolutely sure
     * you’re going to need it. It can be tempting to write general “frameworks”
     * for every bit of functionality you come across. Resist that urge.
     * You won’t get any real work done—you’ll just be writing code that you never use.
     */
}
