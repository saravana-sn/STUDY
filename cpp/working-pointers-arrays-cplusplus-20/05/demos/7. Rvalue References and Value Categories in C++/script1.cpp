#include <iostream>

void fun(const int &x)
{
  std::cout << x << std::endl;
}

int main()
{
  int num = 5;
  fun(num);
  fun(10);
}