#include <iostream>

int main()
{
  int x = 3;
  int y = 5;
  int *p = &x;  //*=dereference operator 
  std::cout << "x: " << x << std::endl;   // 3
  std::cout << "y: " << y << std::endl;   // 5
  std::cout << "*p: " << *p << std::endl; // 3
  std::cout << "p: " << p << std::endl; 
  *p += y;                                // *p = *p + y
  p = &y;
  *p += 5;                                // *p = *p + 5
  std::cout << "x: " << x << std::endl;   // 8
  std::cout << "y: " << y << std::endl;   // 10
  std::cout << "*p: " << *p << std::endl; // 10

}