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
    cout << "Hello world!" << endl;
    return 0;
}
