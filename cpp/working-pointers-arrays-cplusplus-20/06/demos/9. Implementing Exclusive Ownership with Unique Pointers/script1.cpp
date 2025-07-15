#include <iostream>
#include <utility>
#include <memory>

template <typename T>
class smart_ptr
{
  T *raw_ptr;

public:
  smart_ptr() : raw_ptr(nullptr) {}
  smart_ptr(T *ptr) : raw_ptr(ptr) {}

  T &operator*() { return *raw_ptr; }
  T *operator->() { return raw_ptr; }

  smart_ptr(const smart_ptr &other) = delete;
  smart_ptr &operator=(const smart_ptr &other) = delete;

  smart_ptr(smart_ptr &&other) noexcept
      : raw_ptr(other.raw_ptr)
  {
    other.raw_ptr = nullptr;
  }

  smart_ptr &operator=(smart_ptr &&other) noexcept
  {
    if (this == &other)
      return *this;

    delete raw_ptr;
    raw_ptr = other.raw_ptr;
    other.raw_ptr = nullptr;

    return *this;
  }

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
  // smart_ptr<Complex> c = new Complex(2, 3);

  // std::unique_ptr<Complex> c(new Complex(2, 3));
  auto c = std::make_unique<Complex>(2, 3);

  // smart_ptr<Complex> c2 = std::move(c);
  std::unique_ptr<Complex> c2 = std::move(c);
}