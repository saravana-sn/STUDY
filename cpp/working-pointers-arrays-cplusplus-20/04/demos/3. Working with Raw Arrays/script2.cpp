#include <iostream>

int main()
{
  // int other_x;
  // std::cin >> other_x;
  // const int SIZE = other_x;
  constexpr int SIZE = 4;
  int x[SIZE] = {1, 2, 3, 4};

  for (int i = 0; i < SIZE; i++)
    std::cout << x[i] << std::endl;
}