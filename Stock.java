/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockcontrol;

import java.util.HashMap;

/**
 *
 * @author sarahmcneill
 */
public class Stock
{
 private String productNumber;
 private Integer quantity;
 private static HashMap<String, Integer>stockLevelsMap;
 
 
 public Stock(String productNumber, Integer quantity)
 {
 this.productNumber = productNumber;
 this.quantity = quantity;
 this.stockLevelsMap = new HashMap<String, Integer>();
 }
 public Stock()
 {
 
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
     * @return the quantity
     */
    public Integer getQuantity()
    {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    /**
     * @return the stockLevelsMap
     */
    public HashMap<String, Integer> getStockLevelsMap()
    {
        return stockLevelsMap;
    }

//    /**
//     * @param stockLevelsMap the stockLevelsMap to set
//     */
//    public void setStockLevelsMap(HashMap<String, Integer> stockLevelsMap)
//    {
//        this.stockLevelsMap = stockLevelsMap;
//    }
    public void putStockLevels(String productNumber, Integer quantity){
    
    stockLevelsMap.put(productNumber, quantity);
    }


}
