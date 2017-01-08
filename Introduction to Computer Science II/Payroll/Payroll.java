/**
 * Write a description of class Payroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Payroll
{
    // instance variables - replace the example below with your own
    private String id;
    private String first;
    private String last;
    private double grossPay;
    private double netPay;
    private final double STATE_TAX_RATE;
    private final double FED_TAX_RATE;
    private final double FICA_TAX_RATE;
    private static int numberOfEmployees = 0;

    /**
     * Constructor for objects of class Payroll
     */
    public Payroll()
    {
        id = "unknown";
        first = "unknown";
        last = "unknown";
        grossPay = 0;
        netPay = 0;
        numberOfEmployees++;
        STATE_TAX_RATE = 0.035;
        FED_TAX_RATE = 0.15;
        FICA_TAX_RATE = 0.065;
    }

    
    /**
     * Constructor for objects of class Payroll
     */
    public Payroll(String inId, String inFirst, String inLast, double inGrossPay)
    {
        id = new String (inId);
        first = new String (inFirst);
        last = new String (inLast);
        grossPay = new Double (inGrossPay);
        netPay = 0;
        STATE_TAX_RATE = 0.035;
        FED_TAX_RATE = 0.15;
        FICA_TAX_RATE = 0.065;
        numberOfEmployees++;
        setnetPay(inGrossPay);
        getnetpay();
        getgrosspay();
        getnumberofemployees();
    }
    
    public void setnetPay(double grossPay)
    {
        netPay = grossPay - (grossPay * STATE_TAX_RATE) - (grossPay * FED_TAX_RATE) - (grossPay * FICA_TAX_RATE);
    }
    
    public double getnetpay()
    {
        return netPay;
    }
    
    public double getgrosspay()
    {
        return grossPay;
    }
    
    public double getnumberofemployees()
    {
        return numberOfEmployees;
    }
    
    public String toString()
    {
        return "Total Number Of Employees:  " + numberOfEmployees + "\nName " + "\t\tID " + "\tGross Pay " 
        + "\tNet Pay" + "\n" + last + " " + first + "\t" + id + "\t" + grossPay + "\t\t" + netPay;
    }
}