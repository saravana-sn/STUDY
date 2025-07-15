#include <iostream>
#include <string>

int main()
{
  // std::string str = "String";

  char str1[] = {'S', 't', 'r', 'i', 'n', 'g', '\0'};
  char str2[] = "String";
  // const char *str2 = "String";
  str1[1] = 'p';
  str2[1] = 'p';
  std::cout << str1 << std::endl;
  std::cout << str2 << std::endl;
}