#include <iostream>

int main()
{
  std::cout << "A simple calculator" << std::endl;
  std::cout << "Input 4 numbers:" << std::endl;
  int num1, num2, num3, num4;
  std::cin >> num1 >> num2 >> num3 >> num4;

  char op;
  std::cout << "Pick the operator: +, *:" << std::endl;
  std::cin >> op;

  switch (op)
  {
  case '+':
    std::cout << num1 + num2 + num3 + num4 << std::endl;
    break;
  case '*':
    std::cout << num1 * num2 * num3 * num4 << std::endl;
    break;
  default:
    std::cout << "That operator does not exist!" << std::endl;
    break;
  }
}