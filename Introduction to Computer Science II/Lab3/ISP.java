/**
 * Class: ISP
 * Description: This class sets the fields and instance variables
 * for the application. It then calculates and returns the cost 
 * of each package according to the hours the customer spent online.
 * 
 * @author Raymond Ferrell 
 * @version (Version 1.0 September 21, 2014)
 */
public class ISP
{
    // instance variables - replace the example below with your own
    private double costPackageA;
    private double costPackageB;
    private double costPackageC;
    private double hoursUsed;

    /**
     * This constructor sets the original package prices to zero
     * @param costPackageA: the cost of package A.
     * @param costPackageB: the cost of package B.
     * @param costPackageC: the cost of package C.
     * @param hoursUsed: Hours spent online.
     */
    public ISP()
    {
        // initialise instance variables
        costPackageA = 0;
        costPackageB = 0;
        costPackageC = 0;
        hoursUsed = 0;
    }
    
    /**
     * This constructor calls the method to change the package costs.
     * @param hoursSpent: Hours spent online.
     */
    public ISP(double hoursSpent)
    {
        setHours(hoursSpent);
    }
    
    /**
     * This method changes the package costs.
     * @param hoursSpent: Hours spent online.
     */
    public void setHours (double hoursSpent)
    {
        hoursUsed = hoursSpent;
        if (hoursUsed > 10 && hoursUsed <= 25)
        {
           costPackageA = 9.95 + 2*(hoursUsed - 10); // subtracts the base 10 hours
           costPackageB = 18.95;
           costPackageC = 23.5;
        }
        else if (hoursUsed > 25 && hoursUsed >= 10)
        {
           costPackageA = 9.95 + 2*(hoursUsed - 10); // subtracts the base 10 hours
           costPackageB = 18.95 + 1.5*(hoursUsed - 25); // subtracts the base 25 hours
           costPackageC = 23.5;
        }
        else
        {
            costPackageA = 9.95;
            costPackageB = 18.95;
            costPackageC = 23.5;
        }
    }
    
    /**
     * This method changes the package costs.
     * @return hoursUsed: Hours spent online.
     */
    public double getHours()
    {
        return hoursUsed;
    }
    
    /**
     * This method returns the package costs to the driver.
     * @return costPackageA: the cost of package A.
     * @return costPackageB: the cost of package B.
     * @return costPackageC: the cost of package C.
     */
    public double getCost (char option )
    {
        if (option == 'A')
        {
            return costPackageA;
        }
        else if (option == 'B')
        {
            return costPackageB;
        }
        else
        {
            return costPackageC;
        }
    }
}