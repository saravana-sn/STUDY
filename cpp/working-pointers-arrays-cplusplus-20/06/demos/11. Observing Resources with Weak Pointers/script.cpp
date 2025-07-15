#include <iostream>
#include <memory>

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
  auto sp = std::make_shared<Complex>(2, 3);
  std::weak_ptr<Complex> w = sp;
  sp.reset();

  auto sp_lock = w.lock();
  if (sp_lock)
    std::cout << sp_lock->real << ","
              << sp_lock->imag << std::endl;
  else
    std::cout << "Resource doesn't exist anymore" << std::endl;
}