import java.util.*;
/**
 * Class: Driver
 * Description: This class activiates the SaleItem application.
 * It also adds up the total sales price, tax price, 
 * and total money due by the customer, it then subtracts the customer's
 * cash input from the sum and outputs the change.
 * 
 * @author Raymond Ferrell 
 * @version (Version 1.0 September 21, 2014)
 */
public class SaleDriver
{
    /**
     * This method performs all of the driver's tasks
     * @param more: stops the while loop if the customer enters 'n'.
     * @param priceOfItem: the original price of the item.
     * @param discountPercent: The percentage of the original price.
     * @param discountPrice: The item's price after the discount is calculated.
     * @param tax: The tax of the item.
     * @param priceTotal: The total price without tax.
     * @param totalTax: The total tax accumulated.
     * @param subtotal: The discounted price of an item, plus it's tax.
     * @param sum: total money due.
     * @param cash: amount of money customer inputs.
     * @param change: money due to the customer.
     */
    public static void main(String[ ] args)
    {
        Scanner input; // instance of Scanner class
        SaleItem myS; // instance of SaleItem class
        char more = 'y';
        double priceOfItem;
        double discountPercent;
        double discountPrice;
        double tax;
        double priceTotal = 0;
        double totalTax = 0;
        double subtotal = 0;
        double sum = 0;
        double cash = 0;
        double change;
        
        while (more == 'Y' || more == 'y')
        {
            input = new Scanner(System.in);
            System.out.print("Please enter the price of the item: ");
            priceOfItem = input.nextDouble( );
            System.out.print("Please enter the item's discount percentage (do not enter a decimal): ");
            discountPercent = (input.nextDouble( ))/100; // converts percentage to decimal
            myS = new SaleItem(priceOfItem, discountPercent);
            discountPrice = myS.calcDiscountPrice(priceOfItem, discountPercent);
            tax = myS.calcTax(discountPrice);
            totalTax += tax; // collects current tax
            subtotal = discountPrice + tax;
            System.out.println("$" + priceOfItem + " at " + (discountPercent * 100) + "% Off = $" + discountPrice);
            System.out.println("$" + discountPrice + " + tax: $" + tax + " = $" + subtotal);
            priceTotal += discountPrice;
            sum += subtotal; // collects current subtotal
            System.out.print("Do you have more items? Enter Y or N: ");
            more = input.next( ).charAt(0);
        }
        
        input = new Scanner(System.in);
        System.out.println("Price Total: $" + priceTotal + " + Tax Total: $" + totalTax + " = $" + sum);
        System.out.print("Please enter cash value: ");
        cash = input.nextDouble( );
        change = cash - sum;
        System.out.print("You're change is: $" + change);        
    }
}