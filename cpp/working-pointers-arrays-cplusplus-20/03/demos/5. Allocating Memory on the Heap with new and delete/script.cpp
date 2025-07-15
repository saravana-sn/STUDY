#include <iostream>
#include <cstdlib>

class Complex
{
private:
  int real;
  int imag;

public:
  Complex() : real(2), imag(3)
  {
    std::cout << "Complex constructed" << std::endl;
  }
  Complex(int real, int imag) : real(real), imag(imag)
  {
    std::cout << "Complex constructed" << std::endl;
  }
  ~Complex()
  {
    std::cout << "Complex destructed" << std::endl;
  }
};

int main()
{
  //Complex x;

  //Complex *x = (Complex *)std::malloc(sizeof(Complex));
  //std::free(x);

  Complex *x = new Complex();
  delete x;
}
