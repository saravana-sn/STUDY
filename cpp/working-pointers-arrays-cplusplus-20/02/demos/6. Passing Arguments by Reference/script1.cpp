#include <iostream>

void addThree(int &x)
{
  x += 3;
  std::cout << x << std::endl;
}

int main()
{
  int x = 5;
  std::cout << x << std::endl;
  addThree(x);
  std::cout << x << std::endl;

  int &y = x;
  int &z = y;
  std::cout << y << std::endl;
  std::cout << z << std::endl;
}