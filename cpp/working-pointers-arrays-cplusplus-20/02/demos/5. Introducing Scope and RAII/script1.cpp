#include <iostream>

void printInt(int a)
{
  std::cout << a << std::endl;
}

int main()
{
  int x = 5;
  printInt(x);
}

/*
Scope-Based release management (variables are released after its scope ends)
local variables are not accessible in other modules

*/