#include <iostream>

int main()
{
  int x = 5;
  int &y = x;

  std::cout << "x: " << x << std::endl;
  std::cout << "y: " << y << std::endl;
  x++;
  y++;
  std::cout << "x: " << x << std::endl;
  std::cout << "y: " << y << std::endl;
}