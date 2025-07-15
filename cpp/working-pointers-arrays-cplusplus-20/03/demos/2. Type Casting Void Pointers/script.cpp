#include <iostream>

int main()
{
  int x = 2;
  int *i = &x;
  void *v = &x;
  // std::cout << i << std::endl;
  // std::cout << v << std::endl;

  std::cout << *i << std::endl;
  std::cout << *(int *)v << std::endl;
}
