import java.util.*;

/**
 * The module class represents a module or set of modules a student
 * would take while doing on a course
 *
 * @author Brandon Lim-Kee
 * @version 17/02/2021
 */
public class Module
{
    // instance variables - replace the example below with your own
    public String title;
    private String code;
    private int mark;

    /**
     * Constructor for objects of class Module
     */
    public Module(String title, String code)
    {
        // initialise instance variables
        this.title = title;
        this.code = code;
    }

    //Sets a mark to the mark variable
    public void awardMark(int mark)
    {
        this.mark = mark;

        // if the mark is more than 100 it is set to 0 and the user is told to try again
        if(this.mark > 100)
        {
            System.out.println("Error: Mark cannot be higher than 100\n Please try again");

            this.mark = 0;
        }
        // if the mark is less than 40 the student has failed to complete the module
        else if(this.mark < 40)
        {
            System.out.println("Error: You have not completed the module try again");
            this.mark = 0;
        }
    }

    //Returns the mark variable
    public int getMark()
    {
        return mark;
    }

    /**
     * Prints out the details of the module(Code,title and mark)
     */
    public void print()
    {
        // put your code here
        System.out.println("Module: " + code + " - " + title 
            + " " + mark + "%" + "\n");

    }
}
