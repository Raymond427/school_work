/****************************************************/
/* Program: ExtraCredit                             */
/* Author: Raymond Ferrell                          */
/* Lab Section: ITCS 1212- L12                      */
/* Date: 04/29/2014                                 */
/* Purpose: This program asks the user to enter a   */
/*          list of numbers. It then creates a      */
/*          chart of those numbers and displays     */
/*          the number of times they occurred in the*/
/*          list.                                   */
/* Algorithm:                                       */
/* 1. Ask the user for ten numbers.                 */
/* 2. Order the numbers in descending order.        */
/* 3. remove reoccurring numbers from the display   */
/*    list.                                         */
/* 4. Display the number of times the number        */
/*    occurred.                                     */
/****************************************************/

#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
    int frequency[10] = {0}; // list of number occurrences
    int temp = 0; // variable for sorting numbers
    int dispints[10] = {0}; // list of numbers used
    int ints[10] = {0}; // list of numbers entered
    int order[10] = {0}; // assigns a number to each number entered
    int a = 0;
    int b = 0;

    for (int k = 0; k<10; k++)
    {
        cout << "Enter a number: " << endl;
        cin >> ints[k];
    }

    for (int k = 0; k < 10; k++)
    {
        for (int k = 0; k < 10; k++)
        {
            if (ints[k] < ints[k+1])
            {
                temp = ints[k];
                ints[k] = ints[k+1];
                ints[k+1] = temp;
            }
        }
    }
        for (int k = 0; k < 10; k++)
    {
        for (int k = 0; k < 10; k++)
        {
            if (ints[k] != ints[k+1])
            {
                dispints[k] = ints[k];
                order[a] = a;
                a++;
            }
        }
    }

    for (int i = 0; i < 10; i++)
    {
        for (int k = 0; k < 10; k++)
        {
            if (ints[i] == ints[k])
            {
                frequency[k]++;
            }

        }
    }

    cout << "\nN\tCount" << endl;
    for (int k = 0; k<10; k++)
    {
        if (frequency[k] != 0)
        {
            cout << dispints[k] << "\t" << frequency[k] << endl;
        }
    }
    return 0;
}
