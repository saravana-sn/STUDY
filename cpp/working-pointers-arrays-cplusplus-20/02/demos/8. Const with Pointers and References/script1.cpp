#include <iostream>
using namespace std;
int main()
{
  int x = 5;
  const int &y = x;
  //y = 6;
  cout << y;
  x = 6;
  cout << y;

  const int *p = &x;
  cout << *p;
  x=0;
  cout << *p;
  //*p = y;
}