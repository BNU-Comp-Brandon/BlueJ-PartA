/**
 * Represents a product and all its details including name, id and quantity
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * 
 * Edited By Brandon Lim-Kee
 * Version 28/02/2021
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return The product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @return The id, name and quantity in stock.
     */
    public void printDetails()
    {
        System.out.println(id + ": " +  name + " stock level: " + quantity);
    }

    /**
     * Restock with the given amount of this product.
     */
    public void increaseQuantity(int amount)
    {
        if(amount > 0) 
        {
            quantity += amount;
        }
        else 
        {
            System.out.println("Attempt to restock " + name +
                " with a non-positive amount: " + amount);
        }
    }

    /**
     * Sell a quantity of products.
     * An error is reported if there appears to be no stock or 
     * if user tries to sell more quantity than avaliable.
     */
    public void sellQuantity(int amount)
    {
        if(amount == 0)
        {
            System.out.println("Error: Must enter a positive value");
        }
        else if(amount <= quantity) 
        {
            quantity -= amount;
        }
        else if(amount > quantity) 
        {
            System.out.println("Attempt to sell more of a product than in stock");
            System.out.println("Attempt to sell " + amount + " " + name + 
                " when there is only " + quantity + " in stock");
        }
    }
    

}
