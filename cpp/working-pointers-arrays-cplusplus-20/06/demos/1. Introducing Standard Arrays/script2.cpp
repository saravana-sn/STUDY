#include <iostream>
#include <initializer_list> // for std::initializer_list
#include <array>
#include <cstddef> // for std::size_t

template <typename T, int S>
class myArray
{
public:
  T arr[S];

  myArray() = default;
  myArray(std::initializer_list<T> list)
  {
    int i = 0;
    for (auto el : list)
    {
      arr[i] = el;
      i++;
    }
  }
  int size() { return S; }
  T &operator[](int index) { return arr[index]; }
  T &at(int index)
  {
    if (index >= S || index < 0)
    {
      std::cout << "Out of bounds" << std::endl;
      return arr[0];
    }
    else
      return arr[index];
  }
  void fill(T val)
  {
    for (int i = 0; i < S; i++)
      arr[i] = val;
  }
};

template <typename T, std::size_t S>
void printArr(const std::array<T, S> &arr)
{
  for (int i = 0; i < arr.size(); i++)
    std::cout << arr[i] << " ";
  std::cout << std::endl;
}

int main()
{
  int raw[3] = {1, 2, 3};
  // C++20 std::to_array()
  std::array<int, 3> arr = std::to_array(raw);

  printArr(arr);
}