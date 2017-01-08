#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
    int frequency[10] = {0};

    int random = 0;
    bool inList = false;
    int temp = 0;
    int number = 0;
    int dispints[10] = {0};
    int listSize = 0;
    int ints[10] = {0};
    int order[10] = {0};
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
//    for (int k = 0; k < 10; k++)
//    {
//        number = ints[k];
//        for (int k = 0; k < 9; k++)
//        {
//            if(number != ints[k])
//            {
//                dispints[k] = ints[k];
//            }
//        }
//    }
//    for (int k = 0; k<10; k++)
//    {
//        ints[k];
//        frequency[random]++;
//    }

    cout << "\nN\tCount" << endl;
    for (int k = 0; k<10; k++)
    {
        if (dispints[k] != 0)
        {
            cout << dispints[k] << "\t" << frequency[k] << endl;
        }
    }
    return 0;
}
