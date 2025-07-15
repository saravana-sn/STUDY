#include <iostream>
#include <functional>

// Raw pointer can be used for regular functions and lambdas without any captures
// int (*fun)(int, int)
void calculate(int nums[], int size,
               const std::function<int(int, int)> &fun)
{
  int result = nums[0];
  for (int i = 1; i < size; i++)
    result = fun(result, nums[i]);
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
    calculate(nums, SIZE, [](int a, int b)
              { return a + b; });
    break;
  case '*':
    calculate(nums, SIZE, [](int a, int b)
              { return a * b; });
    break;
  default:
    std::cout << "That operator does not exist!" << std::endl;
    break;
  }
}