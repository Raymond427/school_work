/******************************************************/
/* Program: dietSoda                                  */
/* Author: Raymond Ferrell                            */
/* Lab Section: ITCS 1212- L12                        */
/* Date: 02/14/2014                                   */
/* Purpose: This program calculates the               */
/* lethal dose of artificial sweeteners in a          */
/* soda for an adult based on the lethal dose         */
/* for mice.                                          */
/* Algorithm:                                         */
/* 1. Ask the user the lethal volume of soda          */
/*    for a mouse, the weight of the mouse,           */
/*    and the desired weight of the person.           */
/* 2. Divide the desired weight of the person         */
/*    by the weight of the mouse.                     */
/* 3. Multiply this quotient by the lethal amount for */
/*    the mouse to find the user's lethal amount      */
/* 4. Multiply the lethal amount by 0.001 to          */
/*    determine the lethal amount of sweetener.       */
/* 5. Display the lethal amount of soda and           */
/*    sweetener for the user.                         */
/******************************************************/
#include <iostream>

using namespace std;

int main()
{
    float mouseWeight;
    float lethalMouse;
    float desiredWeight;
    float weightRatio;
    float lethalHuman;
    float sodaLethalHuman;
    float desiredOunces;
    const float sweetPercent = 0.001; // Amount of sweetener in each fluid ounce of soda

    cout << "What is the weight of the mouse? (in ounces): " << endl;
    cin >> mouseWeight;

    cout << "What was the lethal dose of sweetener for the mouse? (in fluid onces): " << endl;
    cin >> lethalMouse;

    cout << "What is your desired weight?(in pounds): " << endl;
    cin >> desiredWeight;

    desiredOunces = desiredWeight * 16;

    weightRatio = desiredOunces / mouseWeight; // Ratio between mouse and user weight

    sodaLethalHuman = weightRatio * lethalMouse; // The lethal amount of sweetener for a human

    lethalHuman = sodaLethalHuman / sweetPercent; // The amount of soda in a lethal dose

    cout << "You can consume " << lethalHuman << " ounces of soda, which contains " << sodaLethalHuman << " ounces of sweetener." << endl;

    return 0;
}
