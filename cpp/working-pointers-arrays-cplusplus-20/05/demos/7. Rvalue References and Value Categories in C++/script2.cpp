#include <iostream>

int &fun(int &x){ return x; }

int main()
{
  int num = 5;
  &num;
  int *ptr = &num;
  &ptr;
  int &ref = num;
  &ref;
  fun(num);
  &(fun(num));
}