/****************************************************/
/* Program: computerSalesFunctions                  */
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

void aliasInput(string & NameA, float & SalesA, float & advanceA, double & payCheckA, double & debtA);
double payAmount(float Sales, float advance);

int main()
{
    string Name;
	float Sales;
	float advance;
	double debt;
	double payCheck;

	cout << "Enter your Name: " << endl;
	cin >> Name;

	cout << "Enter your Sales for this month: " << endl;
	cin >> Sales;

	cout << "Did you take any advance pay this month? If not enter 0: " << endl;
	cin >> advance;

    payCheck = payAmount(Sales, advance);

    aliasInput(Name, Sales, advance, payCheck, debt);

    return 0;
}

double payAmount(float Sales, float advance)
{
/*******************************************************************/
/* Name: payAmount                                                 */
/* Purpose: The payAmount function calculates the paycheck earned  */
/* Parameters: Sales: the amount of sales each salesperson earned  */
/*             advance: the amount a salesperson was paid in       */
/*                      advance                                    */
/* Return:                                                         */
/*         payCheck: the amount the salesperson will be paid       */
/*******************************************************************/

    const float CommRate10 = 0.05;
	const float CommRate15 = 0.10;
	const float CommRate18 = 0.12;
	const float CommRate21 = 0.14;
	const float CommRateI = 0.16;
	float commission;
	double payCheck;

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

    return payCheck;
}

void aliasInput(string & NameA, float & SalesA, float & advanceA, double & payCheckA, double & debtA)

/*******************************************************************/
/* Name: aliasInput                                                */
/* Purpose: The aliasInput function demonstrates the ability to    */
/*          label variables multiple names depending on the        */
/*          function and displays the employee's final paycheck.   */
/* Parameters: NameA: The name of the salesperson                  */
/*             SalesA: the amount of sales each salesperson earned */
/*             advance: the amount a salesperson was paid in       */
/*                      advance                                    */
/*             payCheck: the amount the salesperson will be paid   */
/* Return:                                                         */
/*         void: This program does not return a variable           */
/*******************************************************************/

{
    cout << "Name: " << NameA << endl;
    cout << "Sales Earned: " << SalesA << endl;
    cout << "Advance: " << advanceA << endl;

		cout << "Your paycheck this month is: $" << payCheckA << endl;
}
