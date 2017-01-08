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
