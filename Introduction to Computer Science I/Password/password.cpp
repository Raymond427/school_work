#include <iostream>
#include <cstdlib>

/****************************************************/
/* Program: password                                */
/* Author: Raymond Ferrell                          */
/* Lab Section: ITCS 1212- L12                      */
/* Date: 04/29/2014                                 */
/* Purpose: This program uses the challenge-response*/
/*          encryption method to protect the user's */
/*          PIN number.                             */
/* Algorithm:                                       */
/* 1. Ask the user for his or her PIN               */
/* 2. Present the list of numbers, one through nine,*/
/*    and the random numbers assigned to each       */
/*    number, one through 3.                        */
/* 3. Allow the user to input their numbers from the*/
/*    challenge                                     */
/* 4. Display if the numbers are correct or not.    */
/****************************************************/


using namespace std;

int main()
{
    int PIN[5] = {0};  //User's original PIN
    int NUM[10] = {0}; // List of numbers one through nine
    int rands[10] = {0}; // List of random numbers one through three
    int input [5] = {0}; // User's encrypted PIN
    string digit; //Displays which PIN digit is needed
    int encrypt = 0; // generates random number
    bool check = false; // checks encrypted PIN
    int choice = 0; // Current encrypted digit
    int first[10] = {10}; // List of potential numbers for the first PIN digit
    int second[10] = {10}; // List of potential numbers for the second PIN digit
    int third[10] = {10}; // List of potential numbers for the third PIN digit
    int fourth[10] = {10}; // List of potential numbers for the fourth PIN digit
    int fifth[10] = {10}; // List of potential numbers for the fifth PIN digit
    int newPIN[5] = {0}; // User's full entry
    int a = 0; // assigns numbers to slots

    for (int k = 0; k < 5; k++) // fills PIN array
    {
        if (k == 0)
        {
            digit = "first";
            cout << "Enter the " << digit << " digit of your PIN number: ";
            cin >> PIN[k];
        }
        else if (k == 1)
        {
            digit = "second";
            cout << "Enter the " << digit << " digit of your PIN number: ";
            cin >> PIN[k];
        }
        else if (k == 2)
        {
            digit = "third";
            cout << "Enter the " << digit << " digit of your PIN number: ";
            cin >> PIN[k];
        }
        else if (k == 3)
        {
            digit = "fourth";
            cout << "Enter the " << digit << " digit of your PIN number: ";
            cin >> PIN[k];
        }
        else if (k == 4)
        {
            digit = "fifth";
            cout << "Enter the " << digit << " digit of your PIN number: ";
            cin >> PIN[k];
        }
    }
    for (int k = 0; k < 10; k++) // creates random list
    {
        encrypt = rand() % 3 + 1;
        rands [k] = encrypt;
    }
    for (int k = 0; k < 10; k++)
    {
        NUM[k] = k;
    }
    cout << "PIN  ";
    for (int k = 0; k < 10; k++)
    {
        cout << NUM[k] << " "; // prints list of numbers
    }

    cout << "\nNUM  ";
    for (int k = 0; k < 10; k++)
    {
        cout << rands[k] << " "; // prints list of random numbers
    }

    cout << "Please enter the numbers in the NUM list that are below your PIN digits in the PIN list: " << endl;

    for (int k = 0; k < 5; k++)
    {
        if (k == 0)
        {
            digit = "first";
            cout << "Enter the " << digit << " digit: ";
            cin >> input[k];
            choice = input[k];
            for (int k = 0; k < 10; k++)
            {
                if (choice == rands[k]) // chooses which number is assigned to the entry
                {
                    first[a] = k;
                    a++;
                }

            }
            for (int k = 0; k < 10; k++)
            {
                if (PIN[0] == first[k])
                {
                    newPIN[0] = first[k];
                }
            }
            a = 0;
        }
        else if (k == 1)
        {
            digit = "second";
            cout << "Enter the " << digit << " digit: ";
            cin >> input[k];
            choice = input[k];
            for (int k = 0; k < 10; k++)
            {
                if (choice == rands[k])
                {
                    second[a] = k;
                    a++;
                }

            }
            for (int k = 0; k < 10; k++)
            {
                if (PIN[1] == second[k])
                {
                    newPIN[1] = second[k];
                }
            }
            a = 0;
        }
        else if (k == 2)
        {
            digit = "third";
            cout << "Enter the " << digit << " digit: ";
            cin >> input[k];
            choice = input[k];
            for (int k = 0; k < 10; k++)
            {
                if (choice == rands[k])
                {
                    third[a] = k;
                    a++;
                }

            }
            for (int k = 0; k < 10; k++)
            {
                if (PIN[2] == third[k])
                {
                    newPIN[2] = third[k];
                }
            }
            a = 0;
        }
        else if (k == 3)
        {
            digit = "fourth";
            cout << "Enter the " << digit << " digit: ";
            cin >> input[k];
            choice = input[k];
            for (int k = 0; k < 10; k++)
            {
                if (choice == rands[k])
                {
                    fourth[a] = k;
                    a++;
                }

            }
            for (int k = 0; k < 10; k++)
            {
                if (PIN[3] == fourth[k])
                {
                    newPIN[3] = fourth[k];
                }
            }
            a = 0;
        }
        else if (k == 4)
        {
            digit = "fifth";
            cout << "Enter the " << digit << " digit: ";
            cin >> input[k];
            choice = input[k];
            for (int k = 0; k < 10; k++)
            {
                if (choice == rands[k])
                {
                    fifth[a] = k;
                    a++;
                }

            }
            for (int k = 0; k < 10; k++)
            {
                if (PIN[4] == fifth[k])
                {
                    newPIN[4] = fifth[k];
                }
            }
            a = 0;
        }
    }
    for (int k = 0; k < 5; k++)
    {
        if (newPIN[k] == PIN[k])
        {
            check = true;
        }
        else
        {
            check = false;
            break;
        }
    }
    if (check)
    {
        cout << "That PIN is correct!" << endl;
    }
    else
    {
        cout << "Sorry that PIN is invalid" << endl;
    }
    return 0;
}
