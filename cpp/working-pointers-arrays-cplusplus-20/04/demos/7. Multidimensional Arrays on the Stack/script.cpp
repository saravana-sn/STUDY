#include <iostream>

int main()
{
  // int arr[6] = {1, 2, 3, 4, 5, 6};
  int arr[2][3] = {
      {1, 2, 3},
      {4, 5, 6}};
  int num_of_rows = 2;
  int num_of_columns = 3;
  // int row, column;
  // std::cin >> row >> column;
  // std::cout << arr[row * num_of_columns + column] << std::endl;

  for (int row = 0; row < num_of_rows; row++)
  {
    std::cout << "|";
    for (int column = 0; column < num_of_columns; column++)
    {
      std::cout << arr[row][column] << "|";
      // std::cout << arr[row * num_of_columns + column] << "|";
    }
    std::cout << std::endl;
  }
}