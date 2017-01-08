#include <iostream>

using namespace std;

int main()
{
    int iD[10] = {0};
    int iDSales[10] = {0};
    int minimum = 1000000;
    int maximum = 0;
    int a = 0;
    int b = 0;
    int tot = 0;
    int average = 0;
    int iDSought;
    bool iDFound = false;
    int c = 0;

    for(int k=0; k<10; k++)
    {
        cout << "Enter the ID number for employee: " << k << endl;
        cin >> iD[k];
        cout << "Enter the number of sales for " << iD[k] << endl;
        cin >> iDSales[k];
    }
    cout << "\t ID \t Sales" << endl;
    for (int k=0; k<10; k++)
    {
        cout << "\t" << iD[k] << "\t$" << iDSales[k] << endl;
    }

    for (int k=0; k<10; k++)
    {
        if(iDSales[k] < minimum)
        {
            minimum = iDSales[k];
            a = k;
        }
    }
    for (int k=0; k<10; k++)
    {
        if(iDSales[k] > maximum)
        {
            maximum = iDSales[k];
            b = k;
        }
    }
    cout << iD[a] << " Made the minimum amount of sales: $" << iDSales[a] << endl;
    cout << iD[b] << " Made the maximum amount of sales: $" << iDSales[b] << endl;

    for (int k=0; k<10; k++)
    {
        tot += iDSales[k];
    }
    average = tot/10;

    cout << "The average in sales is: $" << average << endl;
    cout << "The employees that sold above average are: " << endl;

    for (int k=0; k<10; k++)
    {
        if (iDSales[k] > average)
        {
            cout << iD[k] << ", " << endl;
        }
    }

    cout << "The employees that sold below average are: " << endl;

    for (int k=0; k<10; k++)
    {
        if (iD[k] < average)
        {
            cout << iDSales[k] << ", " << endl;
        }
    }

    cout << "\nEnter an employee ID number you would like to search for: " << endl;
    cin >> iDSought;

    for (int k=0; k<10; k++)
    {
        if (iD[k] == iDSought)
        {
            iDFound = true;
            c = k;
        }
    }
    if (iDFound == true)
    {
        cout << "Employee: " << iD[c] << "\nSales: $" << iDSales[c] << endl;
    }
    else
    {
        cout << "ID not found" << endl;
    }

    return 0;
}
