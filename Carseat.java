import java.text.*;
/**
 * Author: Joshua Chukwuezi C18709101
 * DT354 Year 1
 */
public class Carseat extends Hardware //1.3 Carseat Class
{
    private boolean recline;
    private boolean vatFree;
    private int harnessPoints;

    public Carseat(String b, int sl, double p, boolean g, double w, int s, boolean r, boolean v, int hp)
    {
        super (b , sl , p , g ,w, s);
        this.recline=r;
        this.vatFree=v;
        this.harnessPoints=hp;
    }

    //getter methods
    public boolean getRecline()
    {
        return this.recline;
    }

    public boolean getvatFree()
    {
        return this.vatFree;
    }

    public int getharnessPoints()
    {
        return this.harnessPoints;
    }

    //setter methods
    public void setRecline(boolean r)
    {
        this.recline=r;
    }

    public void setvatFree(boolean v)
    {
        this.vatFree=v;
    }

    public void setharnessPoints(int hp)
    {
        this.harnessPoints=hp;
    }

    //method to calculate final price
    public double calculateFinalPrice()
    {
        double finalPrice;

        if (this.vatFree==false)
            finalPrice= this.getPrice() + (0.135*this.getPrice()); 
        else
            finalPrice= this.getPrice();

        return finalPrice;
    }

    //toString and equals methods
    public boolean equals (Object anObject)
    {
        //3/4/19 might need to check instance of
        super.equals(anObject);
        Carseat aCarseat = (Carseat) anObject;
        if (super.equals(anObject)
        && this.recline==aCarseat.getRecline()
        && this.vatFree==aCarseat.getvatFree()
        && this.harnessPoints==aCarseat.getharnessPoints())
            return true;
        else 
            return false;
    }

    public String toString()
    {
        DecimalFormat df= new DecimalFormat("#.00"); //to round price including VAT to 2 decimal places
        
        return super.toString() + "\n" + "Recline : " + " " + this.recline + "\n" + "VAT Free? : " + " " + this.vatFree + "\n" + 
        "Number of harness points " + this.harnessPoints + "\n" + "Price including VAT : "+ df.format(calculateFinalPrice());  //need to check code for this final price method
    } 

    
}
