#include <iostream>

using namespace std;

int main()
{
    float precip[4][12] = {0};
    float yearTot[4] = {0};
    float high = 0;
    int a = 0;
    float juneTot = 0;

    for (int i = 0; i<4; i++)
    {
        for (int k = 0; k<12; k++)
        {
            cout << "Enter the precipitation for month " << k+1 << " On year " << i+1 << endl;
            cin >> precip[i][k];
            yearTot[i] += precip[i][k];
        }
    }

    cout << "\tYear 1\tYear 2\tYear 3\tYear 4" << endl;

        for (int i = 0; i<4; i++)
    {
        for (int k = 0; k<12; k++)
        {
            cout << "\t" << precip[0][k] << "\t" << precip[1][k] << "\t" << precip[2][k] << "\t" << precip[3][k] << endl;
        }
    }

    cout << "The total rainfall for year 2 was: " << yearTot[1];
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
    cout << "The highest rainfall in year 3 was " << high << " inches on month " << a << endl;

    for (int k = 0; k < 4; k++)
    {
        juneTot += precip[k][5];
    }

    cout << "The average rainfall for June is: " << juneTot/4 << endl;
    return 0;
}
