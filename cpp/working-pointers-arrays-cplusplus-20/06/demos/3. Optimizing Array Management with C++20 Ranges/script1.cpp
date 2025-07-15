#include <iostream>
#include <initializer_list> // for std::initializer_list
#include <array>
#include <cstddef> // for std::size_t
#include <algorithm>
#include <ranges>

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

  // std::ranges::sort(arr);
  // for (int el : arr)
  //   std::cout << el << " ";
  // std::cout << std::endl;

  for (int el : arr | std::views::filter([](int i)
                                         { return i % 2 == 1; }) |
                    std::views::transform([](int i)
                                          { return i * 10; }))
    std::cout << el << " ";
  std::cout << std::endl;

  // std::array<int, 3> oddArr{};
  // std::copy_if(
  //     arr.begin(),
  //     arr.end(),
  //     oddArr.begin(),
  //     [](int i)
  //     { return i % 2 == 1; });

  // std::array<int, 3> timesTenArr{};
  // std::transform(
  //     oddArr.begin(),
  //     oddArr.end(),
  //     timesTenArr.begin(),
  //     [](int i)
  //     { return i * 10; });

  // for (int el : timesTenArr)
  //   std::cout << el << " ";
  // std::cout << std::endl;
}