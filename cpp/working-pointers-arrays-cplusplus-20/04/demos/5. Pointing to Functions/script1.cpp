#include <iostream>

int sum(int a, int b)
{
  return a + b;
}

int main()
{
  // int (*fun)(int, int) = sum;
  auto *fun = sum;
  // std::cout << (*fun)(2, 3) << std::endl;
  std::cout << fun(2, 3) << std::endl;
}