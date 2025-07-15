#include <iostream>

void printInt(int a)
{
  std::cout << a << std::endl;
}

int main()
{
  int x = 5;
  // printInt(x);

  {
    int i;
    for (i = 0; i < 3; i++)
    {
      std::cout << i << std::endl;
    }
  }
  std::cout << i << std::endl;
}