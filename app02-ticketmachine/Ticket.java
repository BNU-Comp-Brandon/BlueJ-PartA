/**
 * The Class is a representation of a ticket a customer
 * would purchase. It holds a destination cost and date
 *
 * @author Brandon Lim-Kee
 * @version 06/02/2021
 */
import java.util.Date;
import java.text.NumberFormat;
public class Ticket
{

    public String destination;

    public float cost;
    
    //Used to display the current date
    public Date date;
    
    //Used to convert any number ouput to the user in a currency form
    public NumberFormat currency = NumberFormat.getCurrencyInstance();

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String destination, float cost)
    {
        this.destination = destination;
        this.cost = cost;
        this.date = new Date();
    }
    
    /**
     * Method to show details of a ticket to the user before a purchase
     */
    public void details()
    {
        System.out.println("Destination: " + destination + "\nCost: " +
            currency.format(cost) + "\n");
    }

    /**
     * Method to print the ticket out to the customer after a purchase
     */
    public void print()
    {

        System.out.println("\nDestination: " + destination + "\nCost: " +
            currency.format(cost) + "\nDate: " + date);
    }
}
