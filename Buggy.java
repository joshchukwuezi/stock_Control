
/**
 * Author: Joshua Chukwuezi C18709101
 *  DT354 Year 1
 */
public class Buggy extends Hardware //1.2 Buggy Class
{   private String tyreType; //air filled or foam filled
    private boolean overnightSleep;
    private int wheelNumber;
    
    public Buggy(String b, int sl, double p, boolean g, double w, int s, String tt, boolean os, int wn)
    {
        super (b , sl , p , g ,w, s);
        this.tyreType=tt;
        this.overnightSleep=os;
        this.wheelNumber=wn;

    }
    
    //getter methods
    public String gettyreType()
    {
        return this.tyreType;
    }
    
    public boolean getOvernightSleep()
    {
        return this.overnightSleep;
    }
    
    public int getwheelNumber()
    {
        return this.wheelNumber;
    }
    
    //setter methods
    public void settyreType(String tt)
    {
        this.tyreType=tt;
    }
    
    public void setOvernightSleep(boolean os)
    {
        this.overnightSleep= os;
    }
    
    public void setwheelNumber(int wn)
    {
        this.wheelNumber=wn;
    }
    
    //toString and equals to methods
    public boolean equals (Object anObject)
    {   super.equals(anObject);
        Buggy aBuggy= (Buggy) anObject;
        if (super.equals(anObject)
        && this.tyreType.equals(aBuggy.gettyreType())
        && this.overnightSleep==aBuggy.getOvernightSleep()
        && this.wheelNumber==aBuggy.getwheelNumber())
        return true;
        else
        return false;
    }
    
    public String toString()
    {
        return super.toString() + "\n" + "Tyre type : " + this.tyreType + "\n" + "Overnight sleeping : " + this.overnightSleep 
        + "\n" + "Number of wheels : " + this.wheelNumber;
    }
    
}
