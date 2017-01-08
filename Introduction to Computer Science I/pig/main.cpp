#include <iostream>
#include <cstdlib>

using namespace std;



int main()
{
    char choice;
    int diceRoll = 0;
    int totalScore = 0;

    cout << "Hello and welcome to Pig! Roll a die and try to beat the computer to 100 points! If you would like to play enter 'R' or 'r' to roll the die or 'H' or 'h' to hold, press 'q' or 'Q' to quit: " << endl;
    cin >> choice;
    do
    {
        if (choice == 'R' || choice == 'r')
        {
            diceRoll = rand() % 6 + 1;
            if (diceRoll != 1)
            {
                totalScore += diceRoll;
                cout << "You rolled a "<< diceRoll << " Your current score is " << totalScore << " Enter 'R' or 'r' to roll again or 'H' or 'h' to hold!" << endl;
                cin >> choice;
            }
            else
            {
                totalScore += diceRoll;
                cout << "Sorry, you rolled a " << diceRoll << " now it's the computer's turn, your score is " << totalScore << endl;
            }
        }
        else if (choice == 'H' || choice == 'h')
        {
            cout << "You chose to hold. Now it's the computer's turn." << endl;
            break;
        }
        else if (choice == 'q' || choice == 'Q')
        {
            cout << "Thank You for playing!" << endl;
            break;
        }
        else
        {
            cout << "That input is invalid, Please enter 'R' or 'r' to roll the die or 'H' or 'h' to quit: " << endl;
        }

    }while (totalScore < 100);
    if (totalScore >= 100)
    {
        cout << "Congratulations! your score is: "<< totalScore << " you have won! Thanks for playing!";
    }

    return 0;
}
