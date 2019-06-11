import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
/**
 * Author: Joshua Chukwuezi
 * DT354 Year 1
 */
public class Driver //Task 2. Create driver class
{   //create array
    ArrayList <Hardware> list;
    int numberProducts;
    public Driver()
    {
        list= new ArrayList <Hardware> ();
        readFromFile();

        //System.out.print("\f");
        systemMenu();

    }  

    public void systemMenu() //2.1 Create System Menu
    {
        Scanner scan= new Scanner(System.in);

        String menuOption;
        do
        {
            System.out.println("\n\nWelcome to the Mothercare Stock Control System, Please select which menu you will use");
            System.out.println("1. Customer Menu");
            System.out.println("2. Staff Menu");
            System.out.println("3. Exit System");

            menuOption=scan.nextLine();

            if (!(menuOption.equals("1") || menuOption.equals("2") || menuOption.equals("3")))
                System.out.println("ERROR-Enter an option from the menu");
            if (menuOption.equals("1"))
                customerMenu();
            if (menuOption.equals("2"))
                staffMenu();
            if (menuOption.equals("3"))
            {   
                System.out.println("Thank you for shopping at Mothercare, have a great day");
                savetoFile();
            }
        } while (!(menuOption.equals("3")));

    }

    public void customerMenu() //2.2 Create customer menu 
    {
        Scanner scan= new Scanner(System.in);

        String customerOption;
        do
        {
            System.out.println("\nWelcome to the Customer Menu, please choose one of the menu options below");
            System.out.println("1. Browse the buggy catalogue");
            System.out.println("2. Browse the carseat catalogue");
            System.out.println("3. Buy a buggy");
            System.out.println("4. Buy a car seat");
            System.out.println("5. Exit customer menu");

            customerOption=scan.nextLine();

            if(!(customerOption.equals("1")|| customerOption.equals("2")|| 
                customerOption.equals("3") || customerOption.equals("4") || customerOption.equals("5")))
                System.out.println("ERROR-Enter an option from the menu");

            if (customerOption.equals("1"))
            {
                browsebuggyCatalogue();
            }

            if (customerOption.equals("2"))
            {
                browsecarseatCatalogue();
            }

            if (customerOption.equals("3"))
            {
                buyBuggy();
            }

            if (customerOption.equals("4"))
            {
                buyCarseat();
            }

        } while (!(customerOption.equals("5"))); 

        systemMenu();

    }

    public void staffMenu() //2.3 Create staff menu
    {
        Scanner scan= new Scanner(System.in);

        String staffOption;
        do 
        {
            System.out.println("\n\n Welcome to the staff menu, please choose one of the menu options below");
            System.out.println("1. Add a new buggy to stock");
            System.out.println("2. Add a new car seat to stock");
            System.out.println("3. Record incoming supplies for existing products");
            System.out.println("4. Product Analysis");
            System.out.println("5. Exit staff menu");

            staffOption=scan.nextLine();

            if (!(staffOption.equals("1")|| staffOption.equals("2")|| 
                staffOption.equals("3") || staffOption.equals("4") || staffOption.equals("5")))
                System.out.println("ERROR-Enter an option from the menu");

            if (staffOption.equals("1"))
            {
                addBuggy();
            }

            if (staffOption.equals("2"))
            {
                addCarseat();
            }

            if (staffOption.equals("3"))
            {
                recordNewStock();
            }

            if (staffOption.equals("4"))
            {
                productAnalysis();
            }

        } while (!(staffOption.equals("5")));

        systemMenu();
    }

    public void browsebuggyCatalogue() //2.2.1 Browse Buggy Catalogue
    {
        System.out.println("\n\nDisplay the buggy catalogue");

        if (list.isEmpty())
        {
            System.out.println("There aren't any buggies in stock");
        }
        else // this is an if statement to check if theres nothing in the array
        {
            for (Hardware aHardware : list)
            {
                if (aHardware instanceof Buggy)
                {
                    System.out.println(aHardware.toString());
                }

            }
        }
    }

    public void browsecarseatCatalogue() //2.2.2 Browse Carseat Catalogue
    {
        System.out.println("\n\nDisplay the carseat catalogue");

        if (list.isEmpty())
        {
            System.out.println("There aren't any carseats in stock");
        }
        else // this is an if statement to check if theres nothing in the array
        {
            for (Hardware aHardware : list)
            {
                if (aHardware instanceof Carseat)
                {
                    System.out.println(aHardware.toString());
                }
            }
        }

    }

    public void buyBuggy() //2.2.3 Buy a buggy
    {
        Scanner scan= new Scanner(System.in);

        //the variables that the user will be entering 
        String brand;
        String tyre;
        boolean overnight=false;
        int wheels;
        Buggy aBuggy;
        boolean found = false;
        String ans; 
        //boolean error=false

        System.out.println("Enter the brand of buggy");
        brand = scan.nextLine();

        do 
        {
            System.out.println("Enter the type of tyre [air-filled or foam-filled]");
            tyre= scan.nextLine();

        }while (!(tyre.equalsIgnoreCase("air-filled")|| tyre.equalsIgnoreCase("foam-filled"))); 

        do 
        {
            System.out.println("Is it an overnight sleeper [Y/N]: ");
            ans=scan.nextLine();
            if(ans.equalsIgnoreCase("Y"))
                overnight= true;
            else if (ans.equalsIgnoreCase("N"))
                overnight= false;
        } while (!(ans.equalsIgnoreCase("Y")||ans.equalsIgnoreCase("N")));

        do 
        {
            System.out.println("How many wheels does the buggy have[3 or 4]");
            wheels= scan.nextInt();
        } while (!(wheels==3||wheels==4));

        /*
        mismatch exception if a number isn't entered for the number of tyres question
        try 
        {
        } 

        catch (InputMismatchException e)
        {
        System.out.println("ERROR- enter either 3 or 5");
        error = true;
        }
         */

        aBuggy= new Buggy(brand, 0, 0, false, 0, 0,tyre, overnight, wheels); //the 0s and false aren't being used here
        for (Hardware aHardware: list)
        {
            if (aHardware instanceof Buggy)
            {
                Buggy b = (Buggy) aHardware; //casting Buggy onto hardware
                //System.out.println(b.getBrand()); //TESTING TO SEE WHERE ITS NOT FINDING BUGGY
                if (aBuggy.equals(b)) //comparing the details to Hardware
                {
                    //System.out.println(b.getwheelNumber()); //it works
                    found = true;
                    System.out.println("Buggy found");

                    //test if this method works by hardwiring values.
                    //if it does than come back to this and ask more questions.
                    System.out.println(b.toString());

                    //asking the user how many buggies they would like to buy

                    int amount;
                    System.out.println("How many buggies would you like to buy");
                    amount=scan.nextInt();
                    scan.nextLine();
                    if (amount > b.getStockLevel())
                    {   
                        System.out.println("ERROR- The amount you would like to buy is greater than the amount we have in stock");
                    }

                    else
                    {
                        String option;
                        do
                        {
                            System.out.println("\n\nWould you like to buy the" + " " + b.getBrand() + " " + "buggy [Y/N]");
                            option=scan.nextLine();

                            if (option.equalsIgnoreCase("Y"))
                            {  
                                System.out.println("Thank you for your purchase, have a nice day");
                                //I need to create a method in the hardware class that updates the stock levels after a purchase
                                b.minusStockLevels(amount);
                                b.addSales(amount);
                            }
                            else if (option.equalsIgnoreCase("N"))
                                System.out.println("You will be returned back to the menu");
                        } while (!(option.equalsIgnoreCase("Y")||option.equalsIgnoreCase("N")));    
                    }
                }
            }
        }

        if (!found)
            System.out.println("Buggy not found");
    }

    /* public void addBuggy() //to test buy buggy method
    {
    Buggy buggy1, buggy2;

    buggy1 = new Buggy("Mothercare", 6 , 400,  false , 16, "air-filled" ,true , 4);
    buggy2 = new Buggy("Silvercross", 5, 300,  false, 13, "foam-filled", false, 3); 

    list.add(buggy1);
    list.add(buggy2);

    }  */

    public void addBuggy() //2.3.1 Add new buggy to stock
    {
        Scanner scan= new Scanner(System.in);
        String brand;
        int stockLevel;
        double price;
        String ans;
        boolean guarantee=false;
        double weight;
        String tyreType;
        boolean overnightSleep=false;
        String overnight;
        int wheelNumber;
        Buggy aBuggy;

        System.out.println("Please enter the brand of the buggy");
        brand= scan.nextLine();

        do 
        {
            System.out.println("Enter the type of tyre [air-filled or foam-filled]");
            tyreType= scan.nextLine();

        }while (!(tyreType.equalsIgnoreCase("air-filled")|| tyreType.equalsIgnoreCase("foam-filled"))); 

        System.out.println("What is the maximum weight that this buggy can carry");
        weight=scan.nextDouble();

        scan.nextLine();

        do 
        {
            System.out.println("Is it an overnight sleeper [Y/N]: ");
            overnight=scan.nextLine();
            if(overnight.equalsIgnoreCase("Y"))
                overnightSleep= true;
            else if (overnight.equalsIgnoreCase("N"))
                overnightSleep= false;
        } while (!(overnight.equalsIgnoreCase("Y")||overnight.equalsIgnoreCase("N")));

        System.out.println("Enter the stock level for this buggy");
        stockLevel=scan.nextInt();

        scan.nextLine();

        System.out.println("Enter the price of this buggy");
        price= scan.nextDouble();

        scan.nextLine();
        do
        {
            System.out.println("Does this buggy have a guarantee? [Y/N]");
            ans=scan.nextLine();
            if (ans.equalsIgnoreCase("Y"))
                guarantee = true;
            if (ans.equalsIgnoreCase("N"))
                guarantee = false;
        } while (!(ans.equalsIgnoreCase("Y")||ans.equalsIgnoreCase("N")));

        System.out.println("Enter the number of wheels the buggy has");
        wheelNumber=scan.nextInt();

        aBuggy = new Buggy (brand,stockLevel,price,guarantee,weight, 0 ,tyreType,overnightSleep,wheelNumber);

        //System.out.println(aBuggy.toString());

        list.add(aBuggy);

        System.out.println("You have now added the  " + brand + " " + "to the range of buggies");

    }

    public void buyCarseat() //2.2.4 Buy a carseat
    {
        Scanner scan = new Scanner (System.in);
        //variables that we will need
        Carseat aCarseat;
        String brand;
        String ans;
        boolean recline= false; 
        int harnessPoints;
        boolean found = false;

        System.out.println("Enter the brand of the carseat");
        brand=scan.nextLine();

        do
        {
            System.out.println("Does this carseat recline [Y/N]");
            ans=scan.nextLine();
            if (ans.equalsIgnoreCase("Y"))
                recline = true;
            if (ans.equalsIgnoreCase("N"))
                recline= false;
        } while (!(ans.equalsIgnoreCase("Y") || ans.equalsIgnoreCase("N")));

        do 
        {
            System.out.println("How many harness points does this carseat have [3 or 5]");
            harnessPoints=scan.nextInt();
        } while (!(harnessPoints==5 || harnessPoints ==3));

        aCarseat = new Carseat (brand, 0, 0, false, 0, 0, false, recline, harnessPoints);  

        for (Hardware aHardware: list )
        {
            if (aHardware instanceof Carseat)
            {
                Carseat c = (Carseat) aHardware;
                //TESTING TO SEE IF IT FINDS BRAND 
                //System.out.println(c.getBrand());
                if (aCarseat.equals(c))
                {
                    found = true;
                    System.out.println("Carseat found");
                    System.out.println(c.toString());

                    //asking user how many they would like to buy
                    int amount;
                    System.out.println("How many car seats would you like to buy");
                    amount=scan.nextInt();
                    if (amount > c.getStockLevel())
                    {
                        System.out.println("ERROR- The amount you would like to buy is greater than the amount we have in stock");
                    }
                    else
                    {   
                        String option;
                        do
                        {
                            System.out.println("\n\nWould you like to buy the" + " " + c.getBrand() + " " + "carseat[Y/N]");
                            option=scan.nextLine();
                            if (option.equalsIgnoreCase("Y"))
                            {
                                System.out.println("Thank you for your purchase, have a nice day");
                                c.minusStockLevels(amount);
                                c.addSales(amount);
                            }
                            else if (option.equalsIgnoreCase("N"))
                                System.out.println("You will be returned back to the menu");
                        }while(!(option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("N")));
                    }
                }
            }

        }

        if (!found)
            System.out.println("Carseat not found");
    }

    /*public void addCarseat() //to test buy carseat method
    {
    Carseat carseat1, carseat2;
    // (brand, stockLevel, price, guarantee, weight, recline, VATFree, harness points)                                                  )
    carseat1 = new Carseat("Maxi-cosi", 12, 159, false, 15, false, false, 3);
    carseat2 = new Carseat("Joeie", 15, 285, false, 25, false, false, 5);

    list.add(carseat1);
    list.add(carseat2);

    } */
    public void addCarseat() //2.3.2 Add new carseat to stock
    {
        Scanner scan = new Scanner (System.in);
        String brand;
        int stockLevel;
        double price;
        boolean guarantee=false;
        String guaranteeAns;
        double weight;
        boolean recline=false;
        String reclineAns;
        boolean vatFree=false;
        String vatAns;
        int harnessPoints;
        Carseat aCarseat;

        System.out.println("Enter the brand of the carseat");
        brand=scan.nextLine();

        System.out.println("Enter the price of the carseat");
        price=scan.nextDouble();
        scan.nextLine();

        System.out.println("Enter the stock level for this buggy");
        stockLevel=scan.nextInt();

        scan.nextLine();
        do
        {
            System.out.println("Does this carseat have a guarantee [Y/N]");
            guaranteeAns=scan.nextLine(); 
            if (guaranteeAns.equals("Y"))
                guarantee=true;
            if (guaranteeAns.equals("N"))
                guarantee=false;
        }while (!(guaranteeAns.equals("Y")||guaranteeAns.equals("N")));

        System.out.println("What is the maximum weight that this carseat can carry");
        weight=scan.nextDouble();

        scan.nextLine();
        do
        {
            System.out.println("Can this carseat recline[Y/N]");
            reclineAns=scan.nextLine();
            if (reclineAns.equals("Y"))
                recline=true;
            if (reclineAns.equals("N"))
                recline=false;       
        }while (!(reclineAns.equals("Y")||reclineAns.equals("N")));

        scan.nextLine();
        do
        {
            System.out.println("Is this carseat VAT Free[Y/N]");
            vatAns=scan.nextLine();
            if (vatAns.equalsIgnoreCase("Y"))
                vatFree=true;
            if(vatAns.equalsIgnoreCase("N"))
                vatFree=false;   
        }while(!(vatAns.equalsIgnoreCase("Y")||vatAns.equalsIgnoreCase("N")));

        scan.nextLine();
        do 
        {
            System.out.println("How many harness points does this carseat have [3 or 5]");
            harnessPoints=scan.nextInt();
        } while (!(harnessPoints==5 || harnessPoints ==3));

        aCarseat = new Carseat (brand,stockLevel,price,guarantee,weight,0,recline,vatFree,harnessPoints);

        list.add(aCarseat);

        System.out.println("You have now added the  " + brand + " " + "to the range of carseats");

    }

    public void savetoFile() //Task 4. Save stock from program into a data file
    {
        ObjectOutputStream fileOut;
        try { 
            fileOut= new ObjectOutputStream(new FileOutputStream("hardware.dat"));
            for (Hardware aHardware : list)
            {
                fileOut.writeObject(aHardware);
            }
            fileOut.close();
            System.out.println("Product contents saved");
        }
        catch (IOException e)
        {
            System.out.println("There is no more room left on your drive");

        }
    }

    public boolean readFromFile() // Task 3. Copy stock from data file into the program
    {
        int index=0;
        ObjectInputStream fileIn;
        Hardware aHardware;

        try 
        {
            fileIn = new ObjectInputStream(new FileInputStream("hardware.dat"));;
            System.out.println("Opened file successfully");
            aHardware = (Hardware) fileIn.readObject();
            index = 1;

            while (aHardware != null)
            {
                list.add(aHardware);
                aHardware = (Hardware) fileIn.readObject();
                index++;
            }
            fileIn.close();
            return true;
        }
        catch (IOException e)
        {
            if (index > 0)
            { 
                numberProducts = index;
                return true;
            }
            else
            {
                System.out.println("Products have not been created yet");
                return false;
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class Error");
            return false;
        }

    }

    public void recordNewStock() //2.3.3 Incoming supplies for existing products
    {
        Scanner scan = new Scanner (System.in);
        String brand;
        String ans;
        String tyre;
        int wheels;
        Buggy aBuggy;
        Carseat aCarseat;
        boolean found=false;
        String tyreType;
        boolean overnight=false;
        String setOvernight;
        boolean recline=false;
        String setRecline;
        int harnessPoints;

        do 
        {
            System.out.println("Are you adding incoming stock of carseat (C) or buggy (B)");
            ans=scan.nextLine();
            if(!(ans.equalsIgnoreCase("B")||ans.equalsIgnoreCase("C")))
            {
                System.out.println("Error, Enter [B] for Buggy or [C] for Carseat");
            }
        } while (!(ans.equalsIgnoreCase("B")||ans.equalsIgnoreCase("C")));

        if (ans.equalsIgnoreCase("B"))
        {
            browsebuggyCatalogue();

            System.out.println("Enter the brand of buggy");
            brand = scan.nextLine();

            do 
            {
                System.out.println("Enter the type of tyre [air-filled or foam-filled]");
                tyre= scan.nextLine();

            }while (!(tyre.equalsIgnoreCase("air-filled")|| tyre.equalsIgnoreCase("foam-filled"))); 

            do 
            {
                System.out.println("Is it an overnight sleeper [Y/N]: ");
                ans=scan.nextLine();
                if(ans.equalsIgnoreCase("Y"))
                    overnight= true;
                else if (ans.equalsIgnoreCase("N"))
                    overnight= false;
            } while (!(ans.equalsIgnoreCase("Y")||ans.equalsIgnoreCase("N")));

            do 
            {
                System.out.println("How many wheels does the buggy have[3 or 4]");
                wheels= scan.nextInt();
            } while (!(wheels==3||wheels==4));

            aBuggy= new Buggy(brand, 0, 0, false, 0, 0, tyre, overnight, wheels); //the 0s and false aren't being used here
            for (Hardware aHardware: list)
            {
                if (aHardware instanceof Buggy)
                {
                    Buggy b = (Buggy) aHardware; //casting Buggy onto hardware
                    //System.out.println(b.getBrand()); //TESTING TO SEE WHERE ITS NOT FINDING BUGGY
                    if (aBuggy.equals(b)) //comparing the details to Hardware
                    {
                        //System.out.println(b.getwheelNumber()); //it works
                        found = true;
                        System.out.println("Buggy found");

                        //test if this method works by hardwiring values.
                        //if it does than come back to this and ask more questions.
                        System.out.println(b.toString());

                        //asking the user how many buggies they would like to buy

                        int amount;
                        System.out.println("How many buggies would you like to add to stock");
                        amount=scan.nextInt();

                        System.out.println("You have successfully recorded the new incoming stock for the " + b.getBrand() + " buggy");

                    }
                }
            }

            if (!found)
                System.out.println("Buggy not found");
        }

        else if (ans.equalsIgnoreCase("C"))
        {
            browsecarseatCatalogue();

            System.out.println("What is the brand of the carseat");
            brand=scan.nextLine();

            System.out.println("How many harness points does the carseat have");
            harnessPoints=scan.nextInt();

            do
            {
                System.out.println("Can this carseat recline[Y/N]");
                setRecline=scan.nextLine();
                if (setRecline.equals("Y"))
                    recline=true;
                if (setRecline.equals("N"))
                    recline=false;       
            }while (!(setRecline.equals("Y")||setRecline.equals("N")));

            aCarseat = new Carseat (brand, 0, 0, false, 0, 0, false, recline, harnessPoints);  

            for (Hardware aHardware: list )
            {
                if (aHardware instanceof Carseat)
                {
                    Carseat c = (Carseat) aHardware;
                    //TESTING TO SEE IF IT FINDS BRAND 
                    //System.out.println(c.getBrand());
                    if (aCarseat.equals(c))
                    {
                        found = true;
                        System.out.println("Carseat found");
                        System.out.println(c.toString());

                        //asking user how many they would like to buy
                        int amount;
                        System.out.println("How many would you like to add to stock");
                        amount=scan.nextInt();

                        c.addStockLevels(amount);

                        System.out.println("You have successfully recorded the new incoming stock for the " + c.getBrand() + " carseat");

                    }
                }

            }

            if (!found)
                System.out.println("Carseat not found");
        }
    }

    public void productAnalysis()
    {
        //this module will display the products with the greatest amount of sales and the products with the lowest amount of sales
        Scanner scan = new Scanner (System.in);
        String ans;

        do 
        {
            System.out.println("Are you doing product analysis for a carseat [C] or a buggy [B]");
            ans=scan.nextLine();
            if(!(ans.equalsIgnoreCase("B")||ans.equalsIgnoreCase("C")))
            {
                System.out.println("Error, Enter [B] for Buggy or [C] for Carseat");
            }
        } while (!(ans.equalsIgnoreCase("B")||ans.equalsIgnoreCase("C")));

        if (ans.equalsIgnoreCase("B"))
        {
            for (Hardware aHardware : list)
            {
                if (aHardware instanceof Buggy)
                {
                    Buggy b = (Buggy) aHardware;

                    if (b.getSales()>0)
                    {
                        System.out.println("Displaying the buggies with the most units sold");
                        System.out.println("Brand: " + b.getBrand() + " " + "Number of units sold: " + b.getSales());
                    }

                    if (b.getSales() == 0)
                    {
                        System.out.println("Displaying the buggies with no sales");
                        System.out.println("Brand: "+ b.getBrand());
                    }
                }
            }
        }

        if (ans.equalsIgnoreCase("C"))
        {
            for (Hardware aHardware : list)
            {
                if (aHardware instanceof Carseat)
                {
                    Carseat c = (Carseat) aHardware;
                    if (c.getSales()>0)
                    {
                        System.out.println("Displaying the carseats with the most units sold");
                        System.out.println("Brand: " + c.getBrand() + "Number of units sold" + c.getSales());
                    }

                    if (c.getSales() == 0)
                    {
                        System.out.println("Displaying the carseats with no sales");
                        System.out.println("Brand: "+ c.getBrand());
                    }   
                }
            }
        }

    }

    public static void main (String [] args)
    {
        new Driver();
    }
}

