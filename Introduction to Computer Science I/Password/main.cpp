#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
    int PIN[5] = {0};
    int NUM[10] = {0};
    int rands[10] = {0};
    int input [5] = {0};
    string digit;
    int encrypt = 0;
    bool check = false;
    int choice = 0;
    int first[10] = {10};
    int second[10] = {10};
    int third[10] = {10};
    int fourth[10] = {10};
    int fifth[10] = {10};
    int newPIN[5] = {0};
    int a = 0;

    for (int k = 0; k < 5; k++)
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
    for (int k = 0; k < 10; k++)
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
        cout << NUM[k] << " ";
    }

    cout << "\nNUM  ";
    for (int k = 0; k < 10; k++)
    {
        cout << rands[k] << " ";
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
                if (choice == rands[k])
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
        cout << "Sorry, that PIN is invalid" << endl;
    }
    return 0;
}
