/****************************************************/
/* Program: pig                                     */
/* Author: Raymond Ferrell                          */
/* Lab Section: ITCS 1212- L12                      */
/* Date: 04/21/2014                                 */
/* Purpose: This program plays a game of pig with   */
/*          the user of the program                 */
/* Algorithm:                                       */
/* 1. Ask the user to roll hold or quit             */
/* 2. Randomly generate the results of a dice roll  */
/*    and add the number to the user's total score. */
/* 3. Generate the computer's results by randomly   */
/*    generating numbers 1-6 & adding it to the     */
/*    computer's score                              */
/* 4. Display the results of each player's turn.    */
/*    First to 100 points wins.                     */
/****************************************************/

#include <iostream>
#include <cstdlib>

using namespace std;
int computerTurn(int & CtotalScoreA);

int main()
{
    char choice;
    int diceRoll = 0;   // user's roll
    int totalScore = 0; // user's score
    int CtotalScore = 0; // computer's total score

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
                computerTurn(CtotalScore); // calls the computer to play
            }
        }
        else if (choice == 'H' || choice == 'h')
        {
            cout << "You chose to hold. Now it's the computer's turn." << endl;
            computerTurn(CtotalScore);
            choice = 'r';
        }
        else if (choice == 'q' || choice == 'Q') // stops the game
        {
            cout << "Thank You for playing!" << endl;
            break;
        }
        else // validates input
        {
            cout << "That input is invalid, Please enter 'R' or 'r' to roll the die or 'H' or 'h' to hold: " << endl;
            cin >> choice;
        }
        if (CtotalScore >= 100) // ends the game if the computer wins
        {
            break;
        }

    }while (totalScore < 100);
    if (totalScore >= 100) // ends the game if the user wins
    {
        cout << "Congratulations! your score is: "<< totalScore << " you have won! Thanks for playing!";
    }

    return 0;
}

int computerTurn(int & CtotalScoreA)

/*******************************************************************/
/* Name: computerTurn                                              */
/* Purpose: To simulate the computer's turn in the game by         */
/*          generating the results of it's die rolls and adding    */
/*          them to the computer's score                           */
/* Parameters:                                                     */
/*            firstNumber: The first grade                         */
/*            secondNumber: The second grade                       */
/*            thirdNumber: The third grade                         */
/* Return:                                                         */
/*         CtotalScoreA: In order for the computer to memorize it's*/
/*         score after each turn, an alias was used to carry the   */
/*         value between turns                                     */
/*******************************************************************/

{
    int CdiceRoll = 0; // computer's roll
    int CScore = 0; // counts how many points the computer earned in this turn

    while (CScore <= 20) // ends turn after the computer has earned 20 points
    {
        CdiceRoll = rand() % 6 + 1; // random die
        CScore += CdiceRoll; // adds to turn counter
        CtotalScoreA += CdiceRoll; // adds to total score

        cout << "The computer rolled a " << CdiceRoll << " It's total is: " << CtotalScoreA << endl;
        if (CdiceRoll == 1) // loses turn
        {
            cout << "Now it's your turn." << endl;
            break;
        }

        if (CtotalScoreA >= 100) // prints if the computer wins
        {
            cout << "Sorry, the computer scored over 100 points! Thanks for playing!" << endl;
            break;
        }
    }

    return CtotalScoreA; // returns updated score for computer
}
