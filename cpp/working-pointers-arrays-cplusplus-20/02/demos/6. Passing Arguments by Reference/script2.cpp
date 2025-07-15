#include <iostream>

int addThree(int x)
{
  x += 3;
  std::cout << x << std::endl;
  return x;
}

int main()
{
  int x = 5;
  std::cout << x << std::endl;
  x = addThree(x);
  std::cout << x << std::endl;
}