#include <iostream>
/***************************************************/
/* Program: grade
/* Author: Raymond Ferrell
/* Purpose: This program gives the average of three scores, calculates the test average, and then*/
using namespace std;

double Average(double, double, double);
char Letter(double);
void Display(double, char);

int main()
{
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

    average = Average(firstNumber, secondNumber, thirdNumber);
    letter = Letter(average);
    Display(average, letter);
    return 0;
}

double Average (double firstNumber, double secondNumber, double thirdNumber)
{
    double average;

    average = (firstNumber + secondNumber + thirdNumber) / 3.00;

    return average;
}

char Letter (double average)
{

    char letter;

    if (average >= 90.00)
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

void Display (double average, char letter)
{
    if (average >= 70.00)
        cout << "Your average is: " << average << ", which is an " << letter << ". You can take the next course." << endl;
    else
        cout << "Your average is: " << average << ", which is an " << letter << ". You cannot take the next course." << endl;
}
