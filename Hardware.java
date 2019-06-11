import java.io.*;
/**
 * Hardware is a superclass of Carseat and Buggy
 *Author: Joshua Chukwuezi C18709101
 *DT354 Year 1
 */
public class Hardware implements Serializable // 1. Define classes
//1.1 Hardware Class
{   
    private String brand;
    private int stockLevel;
    private double price;
    private boolean guarantee;
    private double weight;
    private int sales;
    
    //defining class
    public Hardware(String b, int sl, double p, boolean g, double w, int s)
    { 
        this.brand=b;
        this.stockLevel=sl;
        this.price=p;
        this.guarantee=g;
        this.weight=w;
        this.sales = s;
        
    }

    //Getter methods
    public String getBrand()
    {
        return this.brand;
    }

    public int getStockLevel()
    {
        return this.stockLevel;
    }

    public double getPrice()
    {
        return this.price;
    }

    public boolean getGuarantee()
    {
        return this.guarantee;
    }

    public double getWeight()
    {
        return this.weight;
    }
    
    public int getSales()
    {
        return this.sales;
    }

    //Setter methods
    public void setBrand(String b)
    {
        this.brand=b;
    }

    public void setStockLevel(int sl)
    {
        this.stockLevel=sl;
    }

    public void setPrice(double p)
    {
      this.price=p;   
    }

    public void setGuarantee(boolean g)
    {
        this.guarantee=guarantee;
    }

    public void setWeight(double w)
    {
        this.weight=w;
    }
    
    public void setSales(int s)
    {
        this.sales=s;
    }
    
    public String toString()
    {
        return "\n" + "Brand : "+ this.brand + "\n" + "Stock Level : "+ this.stockLevel + "\n" + 
        "Price : "+ this.price + "\n" + "Guarantee : " +this.guarantee +"\n" +"Weight : "+ this.weight + "\n" + "Units sold : "+ this.sales;
    }
    
    //method to compare
    public boolean equals (Object anObject)
    {
        Hardware aHardware = (Hardware) anObject;
        if (this.brand.equals(aHardware.getBrand()))
 
        return true;
        else
        return false;
    }
    
    //method to update stock levels
    public void minusStockLevels (int stockPurchased)
    {
        this.stockLevel=this.stockLevel-stockPurchased;
    }
    
    public void addStockLevels(int stockAdded)
    {
        this.stockLevel=this.stockLevel+stockAdded;
    }
    
    //method to update sales
    public void addSales(int newSales)
    {
        this.sales=this.sales+newSales;
    }
}
