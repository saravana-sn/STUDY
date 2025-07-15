#include <iostream>
#include <cstdlib>
#include <cstddef>

std::size_t allocated_mem = 0;

void *operator new(std::size_t size)
{
  std::cout << "Memory is allocated" << std::endl;
  std::cout << "Allocated size: " << size << std::endl;
  allocated_mem += size;
  return std::malloc(size);
}

void operator delete(void *memory, std::size_t size)
{
  std::cout << "Memory is deallocated" << std::endl;
  std::cout << "Deallocated size: " << size << std::endl;
  allocated_mem -= size;
  std::free(memory);
}

int main()
{
  int *c = new int;
  delete c;

  if (allocated_mem)
    std::cout << "There is a memory leak" << std::endl;
}