#include <iostream>

void fun(const int &ref)
{
  std::cout << "const &ref -> ";
  std::cout << ref << std::endl;
}

void fun(int &&ref)
{
  std::cout << "&&ref -> ";
  std::cout << ref << std::endl;
}

int main()
{
  int num = 5;
  fun(num);
  fun(10);
  // int &&rv_num = 10;
}