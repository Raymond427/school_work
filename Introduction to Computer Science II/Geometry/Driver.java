import java.util.*;
import java.io.*;
/**
 * Class: Driver
 * Description: This class displays the information recieved
 * from the user and returned from the Geometry class.
 * @author Raymond Ferrell
 * @version (Version 1.0 October 11, 2014)
 */
public class Driver
{
    public static void main(String[ ] args)
    {
        Scanner input;      // input object declared to read input
        Geometry myG;       // Geometry object declared to calculate area
        char again = 'y';   // character asigned to trigger the while loop
        char shape;         // character asigned to choose which shape to calculate
        double circleRadius = 0;
        double rectLength = 0;
        double rectWidth = 0;
        double triBase = 0;
        double triHeight = 0;
        double trapHeight = 0;
        double trapBase1 = 0;
        double trapBase2 = 0;
        double circleArea = 0;
        double rectArea = 0;
        double triArea = 0;
        double trapArea = 0;
        
        input = new Scanner(System.in); // input object created
        
        while (again == 'y' || again == 'Y')
        {
            System.out.println("Welcome to the Area Calculator!");
            System.out.println("\tEnter 'C' to find the area of a circle");
            System.out.println("\tEnter 'R' to find the area of a rectangle");
            System.out.println("\tEnter 'T' to find the area of a triangle");
            System.out.println("\tEnter 'Z' to find the area of a trapezoid");
            shape = input.next().charAt(0); // enters the first character into the shape variable
            myG = new Geometry(circleRadius, rectLength, rectWidth, triBase, triHeight, trapHeight, trapBase1, trapBase2); // Geometry object created
            if (shape == 'C' || shape == 'c')
            {
                System.out.println("Enter the circle's radius (in inches): ");
                circleRadius = input.nextDouble();
                circleArea = Geometry.calcCircleArea(circleRadius); // The STATIC method to calculate the circle is called
                if (circleArea != 0)
                {
                    System.out.println("A cirlce with a radius of " + circleRadius + " inches has an area of " + circleArea + " square inches");
                }
                else // error trigger
                {
                    System.out.println("Negative numbers and zeros are not allowed!");
                }
            }
            else if (shape == 'R' || shape == 'r')
            {
                System.out.println("Enter the rectangle's width (in inches): ");
                rectWidth = input.nextDouble();
                System.out.println("Enter the rectangle's length (in inches): ");
                rectLength = input.nextDouble();
                rectArea = Geometry.calcRectArea(rectWidth, rectLength); // The STATIC method to calculate the rectangle is called
                if (rectArea != 0)
                {
                    System.out.println("A rectangle with a length of " + rectLength + " inches and a width of " + rectWidth + " inches has an area of " + rectArea + " square inches");
                }
                else // error trigger
                {
                    System.out.println("Negative numbers and zeros are not allowed!");
                }
            }
            else if (shape == 'T' || shape == 't')
            {
                System.out.println("Enter the triangle's base (in inches): ");
                triBase = input.nextDouble();
                System.out.println("Enter the triangle's height (in inches): ");
                triHeight = input.nextDouble();
                triArea = Geometry.calcTriArea(triBase, triHeight); // The STATIC method to calculate the triangle is called
                if (triArea != 0)
                {
                    System.out.println("A triangle with a base of " + triBase + " inches and a height of " + triHeight + " inches has an area of " + triArea + " square inches");
                }
                else // error trigger
                {
                    System.out.println("Negative numbers and zeros are not allowed!");
                }
            }
            else if (shape == 'Z' || shape == 'z')
            {
                System.out.println("Enter the trapezoid's base (in inches): ");
                trapBase1 = input.nextDouble();
                System.out.println("Enter the trapezoid's second base (in inches): ");
                trapBase2 = input.nextDouble();
                System.out.println("Enter the trapezoid's height (in inches): ");
                trapHeight = input.nextDouble();
                trapArea = Geometry.calcTrapArea(trapBase1, trapBase2, trapHeight); // The STATIC method to calculate the trapezoid is called
                if (trapArea != 0)
                {
                     System.out.println("A trapezoid with a base of " + trapBase1 + " inches and " + trapBase2 + " inches has an area of " + trapArea + " square inches");
                }
                else // error trigger
                {
                    System.out.println("Negative numbers and zeros are not allowed!");
                }
            }
            else // triggers choice error
            {
                System.out.println("Sorry, that input is invalid");
            }
            System.out.println("If you'd like to calculate another shape's area enter 'Y' if not enter 'Q': ");
            again = input.next().charAt(0);
        }
        System.out.println("Thank you for using this calculator!");
    }
}