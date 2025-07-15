#include <iostream>
#include <initializer_list> // for std::initializer_list
#include <array>
#include <cstddef> // for std::size_t
#include <algorithm>

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

  T *begin() { return arr; }
  T *end() { return arr + S; }
};

int main()
{
  std::array<int, 3> arr = {5, 1, 8};

  std::sort(arr.begin(), arr.end());

  // for(int *p = arr.begin(); p != arr.end(); p++)
  //       int el = *p;
  for (int el : arr)
    std::cout << el << " ";
  std::cout << std::endl;
}