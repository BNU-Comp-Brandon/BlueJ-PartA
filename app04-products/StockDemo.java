/**
 * Demonstrate the StockManager and Product classes functions
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * 
 * Edited By Brandon Lim-Kee
 * Version 28/02/2021
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    
    /**
     * Create a StockManager and populates it with
     * 10 sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        manager.addProduct(new Product(101, "Apple"));
        manager.addProduct(new Product(102, "Orange"));
        manager.addProduct(new Product(103, "Strawberry"));
        manager.addProduct(new Product(104, "Peach"));
        manager.addProduct(new Product(105, "Pineapple"));
        manager.addProduct(new Product(106, "Banana"));
        manager.addProduct(new Product(107, "Lemon"));
        manager.addProduct(new Product(108, "atermelon"));
        manager.addProduct(new Product(109, "Lime"));
        manager.addProduct(new Product(110, "Grape"));
    }

    /**
     * Provide a demonstration of how the StockManager meets all
     * the user requirements by making a delivery of each product 
     * re-stocking it by various amounts and then selling each
     * product by various amounts.
     */
    public void runDemo()
    {
        manager.printAllProducts();

        demoDeliverProducts();
        manager.printAllProducts();        

        demoSellProducts();
        manager.printAllProducts();  
        
        demoChangeName();
        manager.printAllProducts();
        
        demoRemoveProduct();
        manager.printAllProducts();

        demoPrintProductThroughName();

        demoCheckLowStock();
    }

    //Demonstrates the delivery of products
    private void demoDeliverProducts()
    { 
        System.out.println("Delivering products");
        manager.deliverProduct(510, 100);
        manager.deliverProduct(101, 100);
        manager.deliverProduct(102, 100);
        manager.deliverProduct(103, 100);
        manager.deliverProduct(104, 100);
        manager.deliverProduct(105, 100);
        manager.deliverProduct(106, 100);
        manager.deliverProduct(107, 100);
        manager.deliverProduct(108, 100);
        manager.deliverProduct(109, 100);
        manager.deliverProduct(110, 100);
    }

    //Demonstrates the selling of products
    private void demoSellProducts()
    {
        System.out.println("Selling products");
        manager.sellProduct(101, 500);
        manager.sellProduct(102, 95);
        manager.sellProduct(103, 5);
        manager.sellProduct(104, 5);
        manager.sellProduct(105, 95);
        manager.sellProduct(106, 5);
        manager.sellProduct(107, 5);
        manager.sellProduct(108, 5);
        manager.sellProduct(109, 95);
        manager.sellProduct(110, 5);
    }

    //Demonstrates the name change feature
    private void demoChangeName()
    {
        manager.changeProductName(108, "Watermelon");
    }

    //Demonstrates the removal of a product
    private void demoRemoveProduct()
    {
        manager.removeProduct(102);
    }

    //Demonstrates printing a list of products given a keyword
    private void demoPrintProductThroughName()
    {
        manager.printProductThroughName("L");
    }

    //Demonstrates checking and printing low stock products information
    private void demoCheckLowStock()
    {
        System.out.println("\nCheck low stock\n");
        manager.checkLowStock();
    }

}
