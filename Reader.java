package stockcontrol;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 *
 * @author sarahmcneill
 */
public class Reader
{

    private String path = "prod_data.txt";
    private String stockPath = "stock_data.txt";
    private String purchasePath = "purchases_data.txt";
    private static HashMap<String, Product> productDataMap = new HashMap<String, Product>();
    private String productNumber;
    private String description;
    private String stringPrice;
    private int quantity;
    private double price;
    private String stringQuantity;
    
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    
    
    public Reader(String filePath)
    {
    
    }

    public Reader()
    {
        
    }
    

    /**
     *
     * @param path
     * @throws IOException
     * reads file and passes data read from file to create new product and adds to HashMap
     */
    public void setProductDataMap(String path) throws IOException
    {
        try{
        String line = "";
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while ((line = reader.readLine()) != null)
            
        {
            //creates an array of String to give index to each element
            if (count >3){
                //splits the line at |
            String[] parts = line.split("\\|", 3);
            if (parts.length >= 2)
            {
                //assigns String variables to each element
                productNumber = parts[0].trim();
                String descriptionRead = parts[1];
                description = String.valueOf(descriptionRead.trim());
                stringPrice = parts[2];
                price = Double.valueOf(stringPrice.trim());
            }
            //Creates new Product and add to HashMap if productNumber does not already exist
            Product product = new Product(productNumber, description, price);
            if (!productDataMap.containsKey(productNumber))
            {
                productDataMap.put(productNumber, product);
            }
        }
            count ++;
            }
        }catch(IOException e) {
        throw new IOException ("cannot read file" , e);
        }
    }
        
    /**
     *
     * @param stockPath
     * @throws IOException
     * reads file and creates instance of Stock and adds to HashMap
     */
    public void setStockLevelsMap(String stockPath) throws IOException
    {
        try{
        System.out.println("1 + " +getProductDataMap());
        String stockLine = "";
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(stockPath));
        Stock stock = new Stock(productNumber, quantity);
        
        while ((stockLine = reader.readLine()) != null)
        {
            
            if (count >3){            
                String[] stockParts = stockLine.split("\\|", 2);

            if (stockParts.length >= 1)
            {
                productNumber = stockParts[0].trim();
                stringQuantity = stockParts[1];
                quantity = Integer.valueOf(stringQuantity.trim());

                if (!stock.getStockLevelsMap().containsKey(productNumber))
                { 
                    stock.putStockLevels(productNumber, quantity);
                }
            }
            
            }
            count ++;
        }
        }catch(IOException e) {
        throw new IOException ("cannot read file" , e);
        }
    }
    
    /**
     *
     * @param purchasePath
     * @param productPrice
     * @return
     * @throws IOException
     * returns running total value of stock sold
     */
    public String getRunningTotal(String purchasePath, String productPrice) throws IOException
    {
        try{
        String runningTotal = "";
        double totalPrice = Double.valueOf(productPrice);
        double filePrice = 0;
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(purchasePath));
        
        while ((purchasePath = reader.readLine()) != null)
        {
            if (count >3)
            {
                String[] priceParts = purchasePath.split("\\|", 0);
                
                if (priceParts.length >= 0)
                {
                    String priceAsString = priceParts[3];
                    System.out.println(priceAsString);
                    filePrice = Double.valueOf(priceAsString.trim());
                }
            }
            totalPrice = totalPrice + filePrice;
            runningTotal = decimalFormat.format(totalPrice);
            count++;
        } 
        return runningTotal;
        }
        catch(IOException e) {
        throw new IOException ("cannot read file" , e);
        }
        }
    
    

    public HashMap<String, Product> getProductDataMap()
    {
        return productDataMap;
    }

}
