/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockcontrol;

//import statements 

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author sarahmcneill 
 * writes and reads a text file
 */
public class Writer {

    //fields
    private String path;//name and location of the text file 
    private String stockPath;
    private String pricePath;
    private String deliveryPath;
    private String purchasePath;
    private boolean appendToFile = false;
    private Stock stock = new Stock();

    public Writer(String filePath) {

        path = "prod_data.txt";
        stockPath = "stock_data.txt";
        pricePath = "price_data.txt";
        deliveryPath = "deliveries_data.txt";
        purchasePath = "purchases_data.txt";
    }

    /**
     *
     * writes to text file
     *
     * @param productCodeLine
     * @param descriptionLine
     * @param priceLine
     * @throws java.io.IOException
     */
    public void writeToFile(String productCodeLine, String descriptionLine, String priceLine) throws IOException 
    {
        try{
        //creates a new filewriter object with the name write passing the file location and the append value (true or false)
        FileWriter write = new FileWriter(path, true); 
        //if the file that is passed doesn't exist it will be created here
        //the FileWriter writes in bytes so it needs the PrintWriter to convert to plain text
        //PrintWriter takes FileWriter as parameter value
        BufferedWriter bufferedWriter = new BufferedWriter(write);
        PrintWriter printLine = new PrintWriter(bufferedWriter);
        //formats the data
        printLine.printf("%-15s %-31s %-10s %n", productCodeLine, "| " + descriptionLine, "| " + priceLine);
        //closes the PrintWriter
        printLine.close();
        }catch(IOException e) {
        throw new IOException ("cannot write to file" , e);
        }
    }

    public void writeToStockFile(String productCodeLine, String stockQuantity) throws IOException 
    {
        try{
        FileWriter write = new FileWriter(stockPath, true);
        BufferedWriter bufferedWriter = new BufferedWriter(write);
        PrintWriter printLine = new PrintWriter(bufferedWriter);
        printLine.printf("%-15s %-9s %n", productCodeLine, "| " + stockQuantity);
        printLine.close();
        }catch(IOException e) {
        throw new IOException ("cannot write to file" , e);
        }
    }

    public void writeToPriceFile(String productCodeLine, String priceLine) throws IOException 
    {
        try{
        FileWriter write = new FileWriter(pricePath, true); 
        BufferedWriter bufferedWriter = new BufferedWriter(write);
        PrintWriter printLine = new PrintWriter(bufferedWriter);
        printLine.printf("%-23s %-15s %n", productCodeLine, "| " + priceLine);
        printLine.close();
        }catch(IOException e) {
        throw new IOException ("cannot write to file" , e);
        }
    }
    //uses values found in the stockLevelsMap to write to file
    public String rewriteStockFile() throws IOException {
        try{
        String stockLevels = "";
        FileWriter write = new FileWriter(stockPath, false);
        BufferedWriter bufferedWriter = new BufferedWriter(write);
        PrintWriter printWrite = new PrintWriter(bufferedWriter);
        //creates headings for the text file
        printWrite.printf("%-15s %n %n %-14s %-9s %n %-24s %n", "Stock Levels", "Product No", "| Quantity", "------------------------");
        //returns all values from stockLevelsMap and formats to write to file keeping underneath headings
        for (HashMap.Entry<String, Integer> stockLevelsEntry : stock.getStockLevelsMap().entrySet()) {
            printWrite.printf("%-15s %-9s %n", stockLevelsEntry.getKey(), "| " + stockLevelsEntry.getValue());

        }
        printWrite.close();
        return stockLevels;
        }catch(IOException e) {
        throw new IOException ("cannot write to file" , e);
        }
    }

    public void writeDeliveryEvents(String date, String productCodeLine, String descriptionLine, String priceLine, String stockQuantity) throws IOException {
        try{
        FileWriter write = new FileWriter(deliveryPath, true); 
        BufferedWriter bufferedWriter = new BufferedWriter(write);
        PrintWriter printLine = new PrintWriter(bufferedWriter);
        printLine.printf("%-18s %-14s %-30s %-11s %-5s %n", date, " | " + productCodeLine, " | " + descriptionLine, " | " + priceLine, " | " + stockQuantity);
        printLine.close();
        }catch(IOException e) {
        throw new IOException ("cannot write to file" , e);
        }
    }

    public String writePurchaseEvents(String purchaseEvents) throws IOException {
        try{
        FileWriter write = new FileWriter(purchasePath, true); 
        BufferedWriter bufferedWriter = new BufferedWriter(write);
        PrintWriter printLine = new PrintWriter(bufferedWriter);
        printLine.printf("%s" + "%n", purchaseEvents);
        printLine.close();
        return purchaseEvents;
        }catch(IOException e) {
        throw new IOException ("cannot write to file" , e);
        }
    }

}

