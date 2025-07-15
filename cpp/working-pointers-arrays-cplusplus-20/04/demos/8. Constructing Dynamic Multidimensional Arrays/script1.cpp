#include <iostream>

int main()
{
  int num_of_rows;
  int num_of_columns;
  std::cin >> num_of_rows >> num_of_columns;
  int **arr = new int *[num_of_rows];

  for (int i = 0; i < num_of_rows; i++)
    arr[i] = new int[num_of_columns];

  // Don't forget to initialize the array
  int init_val = 1;
  for (int i = 0; i < num_of_rows; i++)
    for (int j = 0; j < num_of_columns; j++)
      arr[i][j] = init_val++;

  for (int row = 0; row < num_of_rows; row++)
  {
    std::cout << "|";
    for (int column = 0; column < num_of_columns; column++)
    {
      // *( *(arr + row) + column)
      std::cout << arr[row][column] << "|";
    }
    std::cout << std::endl;
  }
}