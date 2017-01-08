//A
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

//B
#include <iostream>

using namespace std;

int main()
{
    string labels[7] = {"Exam 1", "Exam 2", "Exam 3", "Final Exam",
"Take-Home Programming Average", "Lecture", "Lab Grade"};

double weights[7] = {.10, .10, .10, .15, .20, .15, .20};
double myScores[7] = {0};
double multtotal = 0;
double mult = 1;
double average;

for (int k=0; k<7; k++)
{
    cout << "Enter your score for " << labels[k] << ": " << endl;
    cin >> myScores[k];
}

for (int k = 0; k < 7; k++)
{
    myScores[k] = myScores[k]/100;
    myScores[k] = myScores[k] * weights[k];
    multtotal += myScores[k];
}
average = multtotal;
    cout << "Your average in the course is: " << average * 100 << "%" endl;
    return 0;
}

//C

#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
    int frequency[101] = {0};
    int ints[101] = {0};
    int random = 0;

    for (int k = 0; k<101; k++)
    {
        ints[k] = k;
    }

    for (int k = 1; k<10000; k++)
    {
        random = rand() % 100 + 1;
        frequency[random]++;
    }

    for (int k = 0; k<101; k++)
    {
        cout << "The number " << ints[k] << " occurred " << frequency[k] << " times." << endl;
    }
    return 0;
}

//D

#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
    bool used[31] = {false};
    int integer = 0;
    for (int k =0; k<20; k++)
    {
      integer = rand() % 30 + 1;
      if (used[integer] == false)
      {
          cout << integer << endl;
          used[integer] = true;
      }
      else
      {
          k--;
      }
    }
    return 0;
}

//F

#include <iostream>
#include <fstream>

using namespace std;

int main()
{
    float precip[4][12] = {0};
    float yearTot[4] = {0};
    float high = 0;
    int a = 0;
    float juneTot = 0;
    ifstream infile;

    infile.open("C:/Users/ACER/Documents/UNCC/Junior Year (2013-2014)/ITCS 1212 Introduction to Computer Science/LabX/New folder/precipitation.txt");

    for (int i = 0; i<4; i++)
    {
        for (int k = 0; k<12; k++)
        {
            infile >> precip[i][k];
            //cout << "Enter the precipitation for month " << k+1 << " On year " << i+1 << endl;
            //cin >> precip[i][k];
            yearTot[i] += precip[i][k];
        }
    }
    infile.close();

    cout << "\tYear 1\tYear 2\tYear 3\tYear 4" << endl;

        for (int i = 0; i<4; i++)
    {
        for (int k = 0; k<12; k++)
        {
            cout << "\t" << precip[0][k] << "\t" << precip[1][k] << "\t" << precip[2][k] << "\t" << precip[3][k] << endl;
        }
    }

    cout << "The total rainfall for year 2 was: " << yearTot[1] << endl;
    for (int k = 0; k<4; k++)
    {
        cout << "The average rainfall in year " << k+1 << "was: " << yearTot[k]/12 << endl;
    }

    for (int k = 0; k<12; k++)
    {
        if(high < precip[2][k])
        {
            high = precip[2][k];
            a = k;
        }
    }
    cout << "The highest rainfall in year 3 was " << high << " inches on month " << a+1 << endl;

    for (int k = 0; k < 4; k++)
    {
        juneTot += precip[k][5];
    }

    cout << "The average rainfall for June is: " << juneTot/4 << endl;
    return 0;
}
