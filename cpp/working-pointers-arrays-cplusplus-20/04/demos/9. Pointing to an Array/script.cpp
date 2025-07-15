#include <iostream>

int main()
{
  int num_of_rows;
  constexpr int num_of_columns = 3;
  std::cin >> num_of_rows;

  //int(*arr)[num_of_columns][4] = new int[num_of_rows][num_of_columns][4];
  //auto arr = new int[num_of_rows][num_of_columns][4];

  int(*arr)[num_of_columns] = new int[num_of_rows][num_of_columns];
  //*(*(arr+1)+2) == arr[1][2];

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