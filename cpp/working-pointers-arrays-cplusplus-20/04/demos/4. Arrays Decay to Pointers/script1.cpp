#include <iostream>

void printArray(int arr[], int size)
{
  // arr[] parameter is just (int *arr)
  
  for (int i = 0; i < size; i++)
    std::cout << arr[i] << " ";
  std::cout << std::endl;
}

int main()
{
  int nums[3] = {1, 2, 3};

  // std::cout << sizeof(nums) / sizeof(int) << std::endl;

  printArray(nums, 3);
}