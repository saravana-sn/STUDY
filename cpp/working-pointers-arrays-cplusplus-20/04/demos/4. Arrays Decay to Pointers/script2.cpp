#include <iostream>

void sum(int nums[], int size)
{
  int result = nums[0];
  for (int i = 1; i < size; i++)
    result += nums[i];
  std::cout << result << std::endl;
}

void multiply(int nums[], int size)
{
  int result = nums[0];
  for (int i = 1; i < size; i++)
    result *= nums[i];
  std::cout << result << std::endl;
}

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

  switch (op)
  {
  case '+':
    sum(nums, SIZE);
    break;
  case '*':
    multiply(nums, SIZE);
    break;
  default:
    std::cout << "That operator does not exist!" << std::endl;
    break;
  }
}