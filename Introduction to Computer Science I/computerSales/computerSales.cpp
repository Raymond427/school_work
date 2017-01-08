/****************************************************/
/* Program: computerSales                           */
/* Author: Raymond Ferrell                          */
/* Lab Section: ITCS 1212- L12                      */
/* Date: 03/14/2014                                 */
/* Purpose: This program calculates the paycheck    */
/* or debt of each salesperson based on the monthly */
/* sales they earned and their advance.             */
/* Algorithm:                                       */
/* 1. Ask the user for his or her name , sales      */
/*    earned and advance.                           */
/* 2. Calculate their paycheck based on the         */
/*    commission rate they earned multiplied by     */
/*    their monthly sales.                          */
/* 3. Display the paycheck or debt accumulated.     */
/****************************************************/

#include <iostream>

using namespace std;

int main()
{
	string Name;
	float Sales;
	float advance;
	const float CommRate10 = 0.05;
	const float CommRate15 = 0.10;
	const float CommRate18 = 0.12;
	const float CommRate21 = 0.14;
	const float CommRateI = 0.16;
	float commission;
	float payCheck;
	float debt;

	cout << "Enter your Name: " << endl;
	cin >> Name;

	cout << "Enter your Sales for this month: " << endl;
	cin >> Sales;

	cout << "Did you take any advance pay this month? If not enter 0: " << endl;
	cin >> advance;

	if ( Sales < 10000)
	{
		commission = Sales * CommRate10;
	}
	else if (Sales > 10000 && Sales <= 15000)
	{
		commission = Sales * CommRate15;
	}
	else if (Sales > 15000 && Sales <= 18000)
	{
		commission = Sales * CommRate18;
	}
	else if (Sales > 18000 && Sales <= 21000)
	{
		commission = Sales * CommRate21;
	}
	else if (Sales > 21000 )
	{
		commission = Sales * CommRateI;
	}

	payCheck = commission - advance;

	if ( payCheck < 0 )
	{
		debt = payCheck * -1;
		cout << "The money you earned exceeded your paycheck. You owe Hal: $" << debt << endl;
	}
	else
	{
		cout << "Your paycheck this month is: $" << payCheck << endl;
	}
	return 0;
}
