#include <iostream>

class Complex
{
public:
  int real;
  int imag;

  Complex(int real, int imag) : real(real), imag(imag) {}
};

int main()
{
  Complex c = Complex(5, 4);
  std::cout << c.real << " " << c.imag << std::endl;

  Complex *pc = &c;
  // std::cout << (*pc).real << " " << (*pc).imag << std::endl;
  std::cout << pc->real << " " << pc->imag << std::endl;
}