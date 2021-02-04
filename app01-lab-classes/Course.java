
/**
 * The Course class will be used to represent a course a student 
 * would enroll for and will hold a Course Code number and Title
 * 
 * @author Brandon Lim-Kee
 * @version 04/02/21
 */
public class Course
{
     
    private String codeNum;
    
    private String title;

    /**
     * Constructor for objects of class Course
     */
    public Course(String Code, String Title)
    {
        
        codeNum = Code;
        title = Title;
    }

    /**
     * This print function will be used to print the 
     * Code number and title
     */
    public void print()
    {
        System.out.println("Code Number: " + codeNum + "\nTitle: " + title);
    }
}
