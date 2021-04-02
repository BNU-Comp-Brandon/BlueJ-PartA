
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Brandon Lim-Kee
 * @version 20/03/21
 */
public class StockApp
{

    private InputReader reader;
    private StockManager manager;

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        manager = new StockManager();
    }

    /**
     *  Display a list of menu choices and get the user's
     *  choice.
     */
    public void run()
    {
        boolean finished = false;

        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String choice = reader.getString("Please enter your choice > ");
            if (choice.equals("Add") || choice.equals("add"))
            {
                int select = reader.getInt
                ("Enter [1] to add 1 item\nEnter [2] to add multiple");
                if(select == 1)
                {
                    addNewProduct();
                }
                
                else if (select == 2)
                {
                    addMultipleProducts();
                }
                
            }

            else if(choice.equals("Remove") || choice.equals("remove"))
            {
                removeProduct();
            }

            else if(choice.equals("PrintAll"))
            {
                manager.printAllProducts();
            }

            else if(choice.equals("Deliver") || choice.equals("deliver"))
            {
                deliverProduct();
            }
            
            else if(choice.equals("Sell") || choice.equals("sell"))
            {
                sellProduct();
            }
            
            else if(choice.equals("Search") || choice.equals("search"))
            {
                searchProduct();
            }
            
            else if(choice.equals("ReStock") || choice.equals("restock"))
            {
                reStock();
            }
            
            else if (choice.equals("LowStock") || choice.equals("lowstock"))
            {
                printLowStock();
            }
            
            else if (choice.equals("Quit") || choice.equals("quit"))
            {
                System.exit(0);
            }
            
            
        }
    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("   [1]Add:        Add a new product");
        System.out.println("   [2]Remove:     Remove an old product");
        System.out.println("   [3]PrintAll:   Print all products");
        System.out.println("   [4]Deliver:    Increase stock of products");
        System.out.println("   [5]Sell:       Sell products");
        System.out.println("   [6]Search:     Find specific product/s");
        System.out.println("   [7]Re-Stock:   Re-stock all products low on stock");
        System.out.println("   [8]Low-Stock:  Show all products low on stock");
        System.out.println("   [9]Quit:       Quit the program");
        System.out.println();        
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Brandon Lim-Kee");
        System.out.println("******************************");
    }

    /**
     * Creates and adds a new product to the array list
     */
    private void addNewProduct()
    {
        String name = reader.getString("Please enter the name of new product");
        if(manager.isEmpty() == true)
        {
            manager.addProduct(new Product(111,name));
            manager.printAllProducts();
            System.out.println("Added");
        }
        else 
        {
            manager.addProduct(new Product(manager.newID(),name));
            manager.printAllProducts();
            System.out.println("Added");
        }
    }

    /**
     * Removes a product from the array list
     */
    private void removeProduct()
    {
        manager.printAllProducts();
        int id = reader.getInt("Please enter the ID of the Product you wish to remove");
        manager.removeProduct(id);
        manager.printAllProducts();
    }
    
    private void deliverProduct()
    {
        manager.printAllProducts();
        int id = reader.getInt("Please enter the ID of the Product you wish to deliver");
        int amount = reader.getInt("Please enter the amount you would like to deliver");
        manager.deliverProduct(id,amount);
    }
    
    private void sellProduct()
    {
        int id = reader.getInt("Please enter the ID of the Product you wish to sell");
        int amount = reader.getInt("Please enter the amount you would like to sell");
        manager.sellProduct(id,amount);
    }
    
    private void searchProduct()
    {
        String keyword = reader.getString("Please enter a keyword to search for products with");
        manager.search(keyword);
    }
    
    private void reStock()
    {
        if(manager.checkNoProducts() == true)
        {
            System.out.println("There are currently no products in the system");    
        }
        
        else
        {
            manager.printLowStock();
            int amount = reader.getInt("Please enter by how much you would like to Re-stock");
            manager.reStock(amount);
            manager.printAllProducts();
        }
    }
    
    private void printLowStock()
    {
        if(manager.checkNoProducts() == true)
        {
            System.out.println("There are currently no products in the system");
        }
        
        else
        {
            manager.printLowStock();
        }
    }
    
    private void addMultipleProducts()
    {
        int amount = reader.getInt("Please enter the number of products you would like to add");
        for(int i = 0; i < amount; i++)
        {
            addNewProduct();
        }
    }
    
 
}
