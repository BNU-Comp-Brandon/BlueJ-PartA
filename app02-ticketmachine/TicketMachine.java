/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Brandon Lim-Kee
 */
import java.util.Scanner;
import java.text.NumberFormat;

public class TicketMachine
{
    // The amount of money entered by a customer so far.
    private float balance;
    // The total amount of money collected by this machine.
    private float total;

    private Ticket aylesbury;

    private Ticket highWycombe;

    private Ticket amersham;
    
    //Used to hold the ticket info that the user has selected
    private Ticket ticket_selected;
    
    //Used to represent the value of a coin the user inserts
    private Coin coin;
    
    //Used to convert any number being ouput to the user in a currency form
    private NumberFormat currency = NumberFormat.getCurrencyInstance();

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;
        aylesbury = new Ticket("Aylesbury", 2.20f);
        highWycombe = new Ticket("High Wycombe", 3);
        amersham = new Ticket("Amersham", 3.30f);
    }
    
    /**
     * Used to ouput a list of all available tickets to the user 
     * and their details
     */
    public void availableTickets()
    {
        System.out.println("------Available Tickets-----\n");
        aylesbury.details();
        highWycombe.details();
        amersham.details();

    }
    
    /**
     * Method used to allow the user to select a ticket
     * If the user enters an invalid choice the method is reset
     */
    public void selectTicket()
    {
        int i = 0;
        while (i == 0)
        {
            Scanner myObj = new Scanner(System.in);
            availableTickets();
            System.out.println("Please select a ticket [1],[2] or [3]:");
            //Take input from the user 
            String choice = myObj.nextLine();

            //The user can enter "Aylesbury" or "1" both will satisfy the condition
            if(choice.equals ("Aylesbury")||choice.equals("1"))
            {
                ticket_selected = aylesbury;
                System.out.println("You have selected: Aylesbury");
                System.out.println("Please enter: " + 
                    currency.format(ticket_selected.cost));
                    //adds 1 to "i" and ends the loop
                i++;
            }

            else if(choice.equals ("High Wycombe")||choice.equals("2"))
            {
                ticket_selected = highWycombe;
                System.out.println("Please enter: " + 
                    currency.format(ticket_selected.cost));                
                i++;
            }

            else if(choice.equals ("Amersham")||choice.equals("3"))
            {
                ticket_selected = amersham;
                System.out.println("Please enter: " + 
                    currency.format(ticket_selected.cost));                
                i++;
            }

            else
            {
                System.out.println("Please Enter a valid Ticket");

            }
        }
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public float getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(float amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                amount);
        }
    }
    
    /**
     * allows the user enter money using coin amounts(10p,20p...)
     * and displays the current balance to them
     */
    public void insertCoin(Coin coin)
    {
        balance = balance + coin.getValue();
        System.out.println("You have entered " + currency.format(coin.getValue())
            + "\nThe current balance is " + currency.format(balance));
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {

        if(balance >= ticket_selected.cost) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            ticket_selected.print();
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + ticket_selected.cost;
            // Reduce the balance by the price.
            balance = balance - ticket_selected.cost;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                currency.format((ticket_selected.cost - balance)) + " more.");

        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public float refundBalance()
    {
        float amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
