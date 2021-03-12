import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class used to represent how stock is managed
 * 
 * @author Brandon Lim-Kee 
 * @version 28/02/2021
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Increase the quantity of the product by the given amount.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {
            product.increaseQuantity(amount);
        }
    }
    
    /**
     * A method to find a Product in the stock from a given ID
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(id == product.getID())
            {
                return product;
            }
        }
        System.out.println("Error: Could not find ID: " + id);
        return null;
    }
    
    /**
     * Sell a quantity of the given item id and amount.
     */
    public void sellProduct(int id,int amount)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            product.sellQuantity(amount);
        }
    }    

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     */
    public int numberInStock(int id)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {
            return product.quantity;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Remove a product from the stock list given an ID
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        
        System.out.println("Removing product " + product.getName() +
        " from the stock list");
        
        if(product != null)
        {
            stock.remove(product);
        }
    }
    
    /**
     * Prints out a list of products that contain a given keyword
     */
    public void printProductThroughName(String keyword)
    {
        System.out.println("List of products with keyword " + "[" + keyword
        + "]\n");
        
        for(Product product : stock)
        {
            if(product.name.contains(keyword))
            {
                System.out.println(product.toString());
            }
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void printAllProducts()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println("Brandon's Stock List");
        System.out.println("====================");
        System.out.println();
    }
    
    /**
     * Change the product name of a product matching the given ID to the users
     * choice.
     */
    public void changeProductName(int id,String name)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {
            System.out.println("Name change from " + product.getName() + " to "
            + name);
            product.name = name;
        }
    }
    
    /**
     * Prints out products that have stock less than 10
     */
    public void checkLowStock()
    {
        for(Product product: stock)
        {
            if(product.getQuantity() < 10)
            {
                System.out.println(product.getID() + ": " +
                product.name + " is low on stock, only " + 
                product.getQuantity() + " in stock");
            }
        }
    }
}
