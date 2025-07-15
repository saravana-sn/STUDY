#include <iostream>
#include <initializer_list> // for std::initializer_list
#include <array>

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

int main()
{
  // myArray<int, 5> arr1 = {1, 2, 3, 4, 5};
  // myArray<int, 3> arr2 = {1, 2, 3};
  // myArray<double, 4> arr3 = {1.0, 2.0, 3.0, 4.0};

  // myArray<int, 3> arr = {1, 2, 3};
  std::array<int, 3> arr = {1, 2, 3};
  arr[0] = 5;

  for (int i = 0; i < arr.size(); i++)
    std::cout << arr[i] << " ";
  std::cout << std::endl;

  arr.fill(3);
  for (int i = 0; i < arr.size(); i++)
    std::cout << arr[i] << " ";
  std::cout << std::endl;

  arr.at(5);
}