#include <iostream>
#include <utility> // for std::move
#include <memory>

template <typename T>
class smart_ptr
{
  T *raw_ptr;
  int *ref_count;

public:
  smart_ptr() : raw_ptr(nullptr), ref_count(new int(0)) {}
  smart_ptr(T *ptr) : raw_ptr(ptr), ref_count(new int(1)) {}

  int get_ref_count()
  {
    return *ref_count;
  }

  T &operator*() { return *raw_ptr; }
  T *operator->() { return raw_ptr; }

  // Copy constructor
  smart_ptr(const smart_ptr &other)
      : raw_ptr(other.raw_ptr), ref_count(other.ref_count)
  {
    if (other.raw_ptr)
      (*ref_count)++;
  }

  // Copy assignment operator
  smart_ptr &operator=(const smart_ptr &other)
  {
    if (this == &other)
      return *this;

    // Remove this ptr from reference count
    (*ref_count)--;
    // If ref count is 0, remove the resource and ref_count object
    if (!*ref_count)
    {
      delete raw_ptr;
      delete ref_count;
    }

    raw_ptr = other.raw_ptr;
    ref_count = other.ref_count;
    if (other.raw_ptr)
      (*ref_count)++;

    return *this;
  }

  // Move constructor
  smart_ptr(smart_ptr &&other) noexcept
      : raw_ptr(other.raw_ptr), ref_count(other.ref_count)
  {
    other.raw_ptr = nullptr;
    other.ref_count = nullptr;
  }

  // Move assignment operator
  smart_ptr &operator=(smart_ptr &&other) noexcept
  {
    if (this == &other)
      return *this;

    // Remove this ptr from reference count
    (*ref_count)--;
    // If ref count is 0, remove the resource and ref_count object
    if (!*ref_count)
    {
      delete raw_ptr;
      delete ref_count;
    }

    raw_ptr = other.raw_ptr;
    ref_count = other.ref_count;
    other.raw_ptr = nullptr;
    other.ref_count = nullptr;

    return *this;
  }

  // Destructor
  ~smart_ptr()
  {
    if (ref_count)
    {
      // Remove this ptr from reference count
      (*ref_count)--;
      // If ref count is 0, remove the resource and ref_count object
      if (!*ref_count)
      {
        delete raw_ptr;
        delete ref_count;
      }
    }
  }
};

class Complex
{
public:
  int real;
  int imag;

  Complex(int real, int imag)
      : real(real), imag(imag)
  {
    std::cout << "Complex constructed "
              << real << "," << imag << std::endl;
  }
  ~Complex() { std::cout << "Complex destructed "
                         << real << "," << imag << std::endl; }
};

int main()
{
  // smart_ptr<Complex> c = new Complex(2, 3);
  // std::cout << c.get_ref_count() << std::endl;
  // smart_ptr<Complex> c2 = c;
  // std::cout << c.get_ref_count() << std::endl;
  // smart_ptr<Complex> c3 = c2;
  // std::cout << c.get_ref_count() << std::endl;
  // smart_ptr<Complex> c4 = new Complex(5, 6);
  // c3 = std::move(c4);
  // std::cout << c.get_ref_count() << std::endl;


  std::shared_ptr<Complex> c = std::make_shared<Complex>(2, 3);
  std::cout << c.use_count() << std::endl;
  auto c2 = c;
  std::cout << c.use_count() << std::endl;
  auto c3 = c2;
  std::cout << c.use_count() << std::endl;
  auto c4 = std::make_shared<Complex>(5, 6);
  c3 = std::move(c4);
  std::cout << c.use_count() << std::endl;
}