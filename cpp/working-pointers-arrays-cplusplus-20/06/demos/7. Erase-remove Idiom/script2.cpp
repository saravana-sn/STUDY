#include <iostream>
#include <vector>
#include <algorithm>

int main()
{
  std::vector<int> ints = {2, 7, 6, 8, 1, 6, 5};
  // ints.erase(
  //     std::remove(ints.begin(), ints.end(), 6),
  //     ints.end());

  std::erase(ints, 6);
  for (int i : ints)
    std::cout << i << " ";
  std::cout << std::endl;
}