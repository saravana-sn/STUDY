#include <iostream>

int main()
{
  int x = 5;
  int *const p = &x;
  // p = nullptr;
  *p = 6;
}