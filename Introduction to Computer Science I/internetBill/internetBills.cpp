/****************************************************/
/* Program: internetBill                            */
/* Author: Raymond Ferrell                          */
/* Lab Section: ITCS 1212- L12                      */
/* Date: 03/14/2014                                 */
/* Purpose: This program creates a monthly bill     */
/* using the customer's name, account number,       */
/* package type, and hours of internet used.        */
/* Algorithm:                                       */
/* 1. Ask the user for his or her name, account     */
/*    number, package type, and hours of internet   */
/*    activity.                                     */
/* 2. Calculate the amount due according to the     */
/*    package type and hours of activity online.    */
/* 3. Display all information in a monthly bill.    */
/****************************************************/

#include <iostream>

using namespace std;

int main()
{
	string Name;
	double Account;
	char packageType;
	float hoursUsed;
	float amountDue;

	cout << "Please enter your name:" << endl;

	cout << "Name: " << endl;
	cin >> Name;

	cout << "Account #: " << endl;
	cin >> Account;

	cout << "Package Type: " << endl;
	cin >> packageType;

	cout << "Internet Usage (in hours): " << endl;
	cin >> hoursUsed;

	if ( packageType == 'A' || packageType == 'a' )
	{
		if (hoursUsed <= 10)
		{
			amountDue = 10.00;
		}
		else if (hoursUsed > 10)
		{
			amountDue = 10.00 + (hoursUsed - 10)*2.00;
		}
	}
	if ( packageType == 'B' || packageType == 'b' )
	{
		if (hoursUsed <= 25)
		{
			amountDue = 18.95;
		}
		else if (hoursUsed > 25)
		{
			amountDue = 18.95 + (hoursUsed - 25)*1.50;
		}
	}
	if (packageType == 'C' || packageType == 'c' )
	{
		amountDue = 23.50;
	}

	cout << "MONTHLY BILL" << endl;
	cout << "========================================================" << endl;
	cout << "Name: "<< Name << endl;
	cout << "Account Number: " << Account << endl;
	cout << "Package Type: " << packageType << endl;
	cout << "Internet Usage: " << hoursUsed << " hours" << endl;
	cout << "TOTAL COST: $" << amountDue << endl;

	return 0;
}
