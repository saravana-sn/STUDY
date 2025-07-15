#include <iostream>

int main()
{
  constexpr int SIZE = 6;
  std::cout << "A simple calculator" << std::endl;
  std::cout << "Input " << SIZE << " numbers:" << std::endl;
  int nums[SIZE];
  for (int i = 0; i < SIZE; i++)
    std::cin >> nums[i];

  char op;
  std::cout << "Pick the operator: +, *:" << std::endl;
  std::cin >> op;

  int result = nums[0];
  switch (op)
  {
  case '+':
    for (int i = 1; i < SIZE; i++)
      result += nums[i];
    std::cout << result << std::endl;
    break;
  case '*':
    for (int i = 1; i < SIZE; i++)
      result *= nums[i];
    std::cout << result << std::endl;
    break;
  default:
    std::cout << "That operator does not exist!" << std::endl;
    break;
  }
}