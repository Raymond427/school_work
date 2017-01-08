/****************************************************/
/* Program: grade                                   */
/* Author: Raymond Ferrell                          */
/* Lab Section: ITCS 1212- L12                      */
/* Date: 02/14/2014                                 */
/* Purpose: This program gives the average of three */
/* scores, calculates the test average, and then    */
/* displays the result.                             */
/* Algorithm:                                       */
/* 1. Ask the user for his three grades.            */
/* 2. Add the three grades together and divide them */
/*    by three with the function "Average".         */
/* 3. Determine the letter grade, based on the      */
/*    average, with the function "Letter".          */
/* 4. Display the results and whether the user      */
/*    passed or failed with the function "Display". */
/****************************************************/

#include <iostream>

using namespace std;

double Average(double, double, double);
char Letter(double);
void Display(double, char);

int main()
{
/*******************************************************************/
/* Name: main                                                      */
/* Purpose: The main function asks the user for the three          */
/*          grades to enter into the program to be averaged, and   */
/*          calls the three functions to execute                   */
/* Parameters:                                                     */
/*            firstNumber: The first grade                         */
/*            secondNumber: The second grade                       */
/*            thirdNumber: The third grade                         */
/* Return:                                                         */
/*         0: This function does not return a significant value    */
/*******************************************************************/

    double firstNumber;
    double secondNumber;
    double thirdNumber;
    double average;
    char letter;

    cout << "Enter the first test grade: " << endl;
    cin >> firstNumber;

    cout << "Enter the second test grade: " << endl;
    cin >> secondNumber;

    cout << "Enter the third test grade: " << endl;
    cin >> thirdNumber;

    average = Average(firstNumber, secondNumber, thirdNumber); // Calls "Average" function
    letter = Letter(average);                                  // Calls "Letter" function
    Display(average, letter);                                  // Calls "Display" function
    return 0;
}

double Average (double firstNumber, double secondNumber, double thirdNumber)
{
/*******************************************************************/
/* Name: Average                                                   */
/* Purpose: The Average function takes the three values from the   */
/*          main function, adds them together and then divides     */
/*          them by three.                                         */
/* Parameters:                                                     */
/*            firstNumber: The first grade                         */
/*            secondNumber: The second grade                       */
/*            thirdNumber: The third grade                         */
/* Return:                                                         */
/*         average: This function returns the variable "average"   */
/*         for the next two functions.                             */
/*******************************************************************/

    double average;

    average = (firstNumber + secondNumber + thirdNumber) / 3.00; // Averages the test grades

    return average;
}

char Letter (double average)
{

/*******************************************************************/
/* Name: Letter                                                    */
/* Purpose: The Letter function assigns a letter to the            */
/*          corresponding average from the Average function        */
/* Parameters:                                                     */
/*            average: The average of the three grades             */
/* Return:                                                         */
/*         letter: This function returns the variable "letter"     */
/*         for the grade for the average.                          */
/*******************************************************************/

    char letter;

    if (average >= 90.00) // Determines the letter grade
    {
        letter = 'A';
    }
    else if (average < 90.00 && average >= 80.00)
        {
            letter = 'B';
        }
    else if (average < 80.00 && average >= 70.00)
        {
            letter = 'C';
        }
    else if (average < 70.00 && average >= 60.00)
        {
            letter = 'D';
        }
    else
        {
            letter = 'F';
        }

    return letter;
}

void Display (double average, char letter) // Displays final results
{
/*******************************************************************/
/* Name: Display                                                   */
/* Purpose: The Display function creates a final statement,        */
/*          listing the average grade, the letter grade and if     */
/*          the student has passed or failed the class             */
/* Parameters:                                                     */
/*            average: The average grade                           */
/*            letter: The letter grade                             */
/* Return:                                                         */
/*         void: This function is void, meaning it does not return */
/*               anything, but it does produce a statement on the  */
/*               command prompt                                    */
/*******************************************************************/

    if (average >= 70.00)
        cout << "Your average is: " << average << ", which is an " << letter << ". You can take the next course." << endl;
    else
        cout << "Your average is: " << average << ", which is an " << letter << ". You cannot take the next course." << endl;
}
