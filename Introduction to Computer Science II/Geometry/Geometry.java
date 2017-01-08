/**
 * Class: Geometry
 * Description: This class recieves the input from the driver to calculate 
 * the area of four different shapes using static methods, then returns the
 * results to the driver.
 * 
 * @author Raymond Ferrell
 * @version (Version 1.0 October 11, 2014)
 */
public class Geometry
{
    private double circleRadius;
    private double rectLength;
    private double rectWidth;
    private double triBase;
    private double triHeight;
    private double trapHeight;
    private double trapBase1;   //first base of the trapezoid
    private double trapBase2;   //second base of the trapezoid
    private static double circleArea;
    private static double rectArea;
    private static double triArea;
    private static double trapArea;

    /**
     * This is the default constructor for creating Geometry objects,
     * it then sets all of the area values to zero.
     */
    public Geometry()
    {
        circleArea = 0;
        rectArea = 0;
        trapArea = 0;
    }

    /**
     * This overloaded constructor calls the methods needed to change the 
     * field and variable values, and sets all of the area values to zero.
     * @param circleRadius: The radius of the circle to be calculated.
     * @param rectLength: The length of a rectangle to be calculated.
     * @param rectWidth: The width of a rectangle to be calculated.
     * @param triBase: The base of a triangle to be calculated.
     * @param triHeight: The height of a triangle to be calculated.
     * @param trapHeight: The height of a trapezoid to be calculated.
     * @param trapBase1: The base of a trapezoid to be calculated.
     * @param trapBase2: The second base of a trapezoid to be calculated.
     */
    public Geometry(double circleRadius, double rectLength, double rectWidth, double triBase, double triHeight, double trapHeight, double trapBase1, double trapBase2)
    {
        circleArea = 0;
        rectArea = 0;
        trapArea = 0;
        calcCircleArea(circleRadius);
        calcRectArea(rectLength, rectWidth);
        calcTriArea(triBase, triHeight);
        calcTrapArea(trapBase1, trapBase2, trapHeight);
    }
    
    /**
     * This static method calculates the area of a circle.
     * @param circleRadius: The radius of the circle to be calculated.
     * @return circleArea: The area of the circle.
     */
    static public double calcCircleArea(double circleRadius)
    {
        if (circleRadius < 0)
            {
                return 0; // triggers error in driver
            }
        else
            {
                circleArea = 3.1416 * circleRadius * circleRadius; // circle area formula
                return circleArea;
            }
    }
    
    /**
     * This static method calculates the area of a rectangle.
     * @param rectLength: The length of the rectangle to be calculated.
     * @param rectWidth: The width of the rectangle to be calculated.
     * @return rectArea: The area of the rectangle.
     */
    static public double calcRectArea(double rectLength, double rectWidth)
    {
        if (rectLength < 0 || rectWidth < 0)
            {
                return 0; // triggers error in driver
            }
        else
            {
                rectArea = rectLength * rectWidth; // rectangle area formula
                return rectArea;
            }
    }
    
    /**
     * This static method calculates the area of a triangle.
     * @param triBase: The base of the trianlge to be calculated.
     * @param triHeight: The height of the triangle to be calculated.
     * @return triArea: The area of the triangle. 
     */
    static public double calcTriArea(double triBase, double triHeight)
    {
        if (triBase < 0 || triHeight < 0)
            {
                return 0; // triggers error in driver
            }
        else
            {
                triArea = 0.5 * (triBase * triHeight); // triangle area formula
                return triArea;
            }
    }
    
    /**
     * This static method calculates the area of a trapezoid.
     * @param trapBase1: The base of the trapezoid to be calculated.
     * @param trapBase2: The second base of a trapezoid to be calculated.
     * @param trapHeight: The height of a trapezoid to be calculated.
     * @return trapArea: The area of the trapezoid. 
     */
    static public double calcTrapArea(double trapBase1, double trapBase2, double trapHeight)
    {
        if (trapBase1 < 0 || trapBase2 < 0 || trapHeight < 0)
            {
                return 0; // triggers error in driver
            }
        else
            {
                trapArea = ((trapBase1 + trapBase2)/2) * trapHeight; // trapezoid area formula
                return trapArea;
            }
    }
}