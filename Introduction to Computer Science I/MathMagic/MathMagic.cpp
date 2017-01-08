/***********************************************************************************/
/*   Program: MathMagic.cpp                                                        /*
/*   Author: Raymond Ferrell                                                       /*
/*   Lab Section: ITCS1212- L12                                                    /*
/*   Date: 1/18/14                                                                 /*
/*   Purpose: This program creates the illusion of producing three random numbers  /*
/*   by using arithmetic operators on the number provided. The given number is     /*
/*   first doubled, then increased by six, divided by two, then lastly, subtracted /*
/*   by the original number. the three numbers are then displayed to the user.     /*
/***********************************************************************************/

#include <iostream>

using namespace std;

int main()
{
   int numberBelowTen;   //Stores an integer value below 10
   int doubleNumber;     //Stores double of number BelowTen
   int addSix;           //Stores the result of sum of 6 and doubleNumber
   int halfNumber;       //Stores the result of half the answer
   int finalAnswer;      //Stores the result of the subtraction of numberBelowTen

   cout << "MATH MAGIC: Enter any number and I will generate 3 " << endl;
   cin >> numberBelowTen;


   doubleNumber = numberBelowTen * 2;

   addSix = doubleNumber + 6;

   halfNumber = addSix / 2;

   finalAnswer = halfNumber - numberBelowTen;

   cout << endl;
   cout << "And the result is: " << finalAnswer << " , " << halfNumber << " & " << addSix <<  endl;

    return 0;
}
