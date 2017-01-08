import java.io.*;
import java.util.*;
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main (String [ ] args)throws IOException
    {
        Scanner input;
        Payroll payroll;
        String line;
        String last;
        String first;
        String id;
        double netPay = 0;
        double FED = 0;
        double STATE = 0;
        double FICA = 0;
        double totalGross = 0;
        double totalNet = 0;
        double grossPay = 0;
        input = new Scanner(new File("C://payrollData.txt"));
        
        FED = input.nextDouble();
        STATE = input.nextDouble();
        FICA = input.nextDouble();
        while (input.hasNext())
        {
            line = input.nextLine();
            last = input.next();
            first = input.next();
            id = input.next();
            grossPay = input.nextDouble();
            payroll = new Payroll(id, first, last, grossPay);
            netPay = payroll.getnetpay();
            totalGross += grossPay;
            totalNet += netPay;
            System.out.println(payroll);
        }
        input.close();
        System.out.println("Total Gross Pay: $" + totalGross);
        System.out.println("Total Net Pay: $" + totalNet);
    }
}