import java.util.ArrayList;
import java.util.*;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock
 * @version 0.1 11/Sep/2020
 * 
 * Modified By Brandon Lim-Kee
 * Dated 17/02/21
 */
public class Course
{
    // instance variables 
    private String codeNo;
    private String title;
    // Array list to hold the 4 modules
    public ArrayList<Module> modules = new ArrayList<Module>();
    // The mean value of all the module marks
    private int mean;
    private Grades grade;

    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNo, String title)
    {
        // initialise instance variables
        this.codeNo = codeNo;
        this.title = title;

    }

    /**
     * Prints out the details of a course(Modules,final grade,Title and codeNo)
     */
    public void print()
    {
        System.out.println("\n \t ------Course Details------\n");
        System.out.println("Course: " + codeNo + " - " + title + "\n");
        
        for(int i = 0; i < 4; i++)
        {
            modules.get(i).print();
        }
        
        System.out.println("Final Grade: " + grade + "\n");
    
    }
    
    //Calculates the mean of the 4 module marks
    public void calculateMean()
    {
        for(int i = 0; i < 4;i++)
        {
            if(modules.get(i).getMark() < 40)
            {
              System.out.println("Error: " + modules.get(i).title + " is not complete");
              break;
            }
        }
        
        for(int i = 0; i < 4;i++)
        {
            mean = mean + modules.get(i).getMark();
        }
        
        int numModules = modules.size();
        mean = mean/numModules;
        
        
    }
    
   
    //Checks the mean against different possible marks to get a final mark
    public Grades getFinalGrade()
    {
        if(mean <= 39)
        {
            grade = grade.F;
        }
        
        else if(mean <= 49)
        {
            grade = grade.D;
        }
        
        else if(mean <= 59)
        {
            grade = grade.C;
        }
        
        else if(mean <= 69)
        {
            grade = grade.B;
        }
        
        else if(mean <= 100)
        {
            grade = grade.A;
        }
        
        return grade;
    }
    
    // Adds 4 modules to the arraylist
    public void addModules(Module module1, Module module2,
    Module module3, Module module4)
    {
        List<Module> moduleList = List.of(module1,module2,module3,module4);
        
        for(int i = 0; i < 4; i++)
        {
            this.modules.add(i, moduleList.get(i));
        }
    }
}