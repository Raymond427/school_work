/*********************************************************/
/* Program: Pizza                                        */
/* Author: Raymond Ferrell                               */
/* Lab Section: ITCS 1212- L12                           */
/* Date: 02/14/2014                                      */
/* Purpose: This program determines the number of        */
/* slices, that are 14.125 square inches in area, that   */
/* can be made from a pizza of any size.                 */
/* Algorithm:                                            */
/* 1. Ask the user the diameter of the pizza.            */
/* 2. Calculate the radius and area of the pizza         */
/* 3. Divide the area of the sector by the total area    */
/*    of the circle.                                     */
/* 4. Display the number of slices possible.             */
/*********************************************************/

#include <iostream>
#include <cmath>

using namespace std;

int main()
{

    float diameterPizza;                       //Diameter of pizza
    float radiusPizza;                         //Radius or pizza
    float areaPizza;                           //Area of pizza
    const float areaOfSlice = 14.125;          //Area Of slice
    int numberSlices;                          //Number of Slices (made into an integer to truncate extra area)
    const float pi = 3.14159;                  //The ratio of the circumference of a circle and it's diameter

    cout << "What is the diameter of your pizza (in inches)?: ";
    cin >> diameterPizza;

    radiusPizza = diameterPizza / 2;

    areaPizza = pi*(pow(radiusPizza, 2));  // Area of a circle

    numberSlices = areaPizza / areaOfSlice; // Number of slices from the pizza area

    cout << numberSlices << " slices can be made from this pizza" << endl;
    return 0;
}
