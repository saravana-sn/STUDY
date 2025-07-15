#include <iostream>
#include <array>

int main()
{
  std::array<std::array<int, 3>, 2> arr2d = {{{1, 2, 3},
                                              {4, 5, 6}}};
  // for(int *p = arr2d.begin(); p != arr2d.end(); p++)
  //       std::array<int, 3> &row = *p;
  for (std::array<int, 3> &row : arr2d)
  {
    for (int el : row)
      std::cout << el << " ";
    std::cout << std::endl;
  }
}