#include <iostream>
#include <functional>

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
  int size;
  std::cout << "A simple calculator" << std::endl;

  std::cout << "How many operands do you need?" << std::endl;
  std::cin >> size;

  std::cout << "Input " << size << " numbers:" << std::endl;
  int *nums = new int[size];
  for (int i = 0; i < size; i++)
    std::cin >> nums[i];

  char op;
  std::cout << "Pick the operator: +, *:" << std::endl;
  std::cin >> op;

  switch (op)
  {
  case '+':
    calculate(nums, size, [](int a, int b)
              { return a + b; });
    break;
  case '*':
    calculate(nums, size, [](int a, int b)
              { return a * b; });
    break;
  default:
    std::cout << "That operator does not exist!" << std::endl;
    break;
  }

  delete[] nums;
}