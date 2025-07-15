#include <iostream>

void printInt(const int *const p)
{
  // *p = 6;
  // p = nullptr;
  std::cout << *p << std::endl;
}

int main()
{
  int x = 5;
  printInt(&x);
}