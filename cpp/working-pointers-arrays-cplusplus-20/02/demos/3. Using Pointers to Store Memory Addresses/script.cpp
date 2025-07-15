#include <iostream>

int main()
{
  int x = 2;
  std::cout << "Value stored in x: " << x << std::endl;
  std::cout << "Memory address of x: " << &x << std::endl;

  int *addr_of_x = &x;
  std::cout << "Value stored in addr_of_x: " << addr_of_x << std::endl;
  std::cout << "Memory address of addr_of_x: " << &addr_of_x << std::endl;

  // int *a, *b, *c;
  // int *a = nullptr; // NULL, 0
}