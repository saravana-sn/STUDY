#include <iostream>

template <typename T>
class smart_ptr
{
  T *raw_ptr;

public:
  smart_ptr() : raw_ptr(nullptr) {}
  smart_ptr(T *ptr) : raw_ptr(ptr) {}

  T &operator*() { return *raw_ptr; }
  T *operator->() { return raw_ptr; }

  ~smart_ptr() { delete raw_ptr; }
};

class Complex
{
public:
  int real;
  int imag;

  Complex(int real, int imag)
      : real(real), imag(imag)
  {
    std::cout << "Complex constructed" << std::endl;
  }
  ~Complex() { std::cout << "Complex destructed" << std::endl; }
};

int main()
{
  // Complex *c = new Complex(2, 3);
  smart_ptr<Complex> c = new Complex(2, 3);
  std::cout << (*c).real << std::endl;
  // std::cout << c->imag << std::endl;
  std::cout << (c.operator->())->imag << std::endl;
}