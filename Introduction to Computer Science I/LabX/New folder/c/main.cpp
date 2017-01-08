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
