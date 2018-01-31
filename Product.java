/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockcontrol;

public class Product
{
    private String productNumber;
    private String description;
    private double price;
 
    public Product(String productNumber, String description, double price){
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;   
    }
  
    /**
     * @return the productNumber
     */
    public String getProductNumber()
    {
        return productNumber;
    }

    /**
     * @param productNumber the productNumber to set
     */
    public void setProductNumber(String productNumber)
    {
        this.productNumber = productNumber;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
  
}
