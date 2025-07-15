#include <iostream>

void printInt(const int &y)
{
  // y = 5;
  std::cout << y << std::endl;
}

int main()
{
  int x = 5;
  printInt(x);
}