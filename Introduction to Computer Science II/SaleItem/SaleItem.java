/**
 * Class: SaleItem
 * Description: This class sets the fields and instance variables
 * for the application. It then calculates the discount price 
 * and tax of each item given to it by the driver class.
 * 
 * @author Raymond Ferrell 
 * @version (Version 1.0 September 21, 2014)
 */

public class SaleItem
{
    private double priceOfItem; // origianl item price
    private double discountPercent; // percentage of price to be removed
    private final double TAX_RATE = 0.075;
    
    /**
     * This constructor sets all of the initial fields to zero.
     * @param TAX_RATE: a constant used to calculate tax
     */
    public SaleItem(final double TAX_RATE)
    {
        priceOfItem = 0;
        discountPercent = 0;
    }
    
    /**
     * This constructor calls the methods needed to change the 
     * field and variable values
     * @param priceOfItem: the original price of the item
     * @param discountPrice: The item's price after the discount is calculated
     */
    public SaleItem(double priceOfItem, double discountPrice)
    {
        setPriceOfItem(priceOfItem);
        setDiscountPercent(discountPrice, discountPercent);       
    }

    /**
     * This method calls the method needed to calculate the 
     * price after the discount is entered.
     * @param priceOfItem: the original price of the item
     */
    public void setPriceOfItem(double priceOfItem)
    {
        calcDiscountPrice(priceOfItem, discountPercent);
    }
    
    /**
     * This method calls the method needed to calculate the 
     * tax.
     * @param discountPrice: The item's price after the discount is calculated
     * @param discountPercent: The percentage of the original price
     * that equals the discount price.
     */
    public void setDiscountPercent(double discountPrice, double discountPercent)
    {
        calcTax(discountPrice);
    }
    
    /**
     * This method calculates the discount price.
     * @param priceOfItem: the original price of the item
     * @param discountPercent: The percentage of the original price
     * that equals the discount price.
     * @return discountPrice: The item's price after the discount is calculated
     * (will equal original price if discountPercent is zero)
     */
    public double calcDiscountPrice(double priceOfItem, double discountPercent)
    {
        if (discountPercent > 0)
        {
            double discountPrice = priceOfItem - (priceOfItem * discountPercent);
            return discountPrice;
        }
        else
        {
            double discountPrice = priceOfItem;
            return discountPrice;
        }        
    }
    
    /**
     * This method calculates the tax.
     * @param discountPrice: The item's price after the discount is calculated
     * @return tax: The tax of the item.
     */
    public double calcTax(double discountPrice)
    {
        double tax = discountPrice * TAX_RATE;
        return tax;
    }
}
