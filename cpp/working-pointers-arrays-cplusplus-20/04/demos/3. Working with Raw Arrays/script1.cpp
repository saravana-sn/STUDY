#include <iostream>

int main()
{
  int x[4] = {1, 2, 3, 4};

  // *(x + 0)
  // std::cout << x[0] << std::endl;

  // x[1] = 5;
  // std::cout << x[1] << std::endl;

  for (int i = 0; i < 4; i++)
    std::cout << x[i] << std::endl;
}