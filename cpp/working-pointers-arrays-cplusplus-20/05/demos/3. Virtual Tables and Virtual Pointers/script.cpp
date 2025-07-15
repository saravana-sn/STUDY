#include <iostream>

class Instrument
{
public:
  bool electric;

  Instrument() : electric(false) {}
  Instrument(bool el) : electric(el) {}
  virtual void play()
  {
    std::cout << "Instrument sound." << std::endl;
  }
};

class Guitar : public Instrument
{
  int num_of_strings;

public:
  Guitar() : num_of_strings(6) {}
  Guitar(int nos) : num_of_strings(nos) {}
  Guitar(bool el) : Instrument(el), num_of_strings(6) {}
  Guitar(bool el, int nos) : Instrument(el), num_of_strings(nos) {}
  void play() override
  {
    std::cout << "Guitar sound with "
              << num_of_strings << " strings." << std::endl;
  }
};

class Synth : public Instrument
{
  int num_of_keys;

public:
  Synth() : Instrument(true), num_of_keys(88) {}
  Synth(int nok) : Instrument(true), num_of_keys(nok) {}
  void play() override
  {
    std::cout << "Synth sound with "
              << num_of_keys << " keys." << std::endl;
  }
};

int main()
{
  std::cout << "Instrument: "
            << sizeof(Instrument) << "B" << std::endl;
  std::cout << "Guitar: "
            << sizeof(Guitar) << "B" << std::endl;
  std::cout << "Synth: "
            << sizeof(Synth) << "B" << std::endl;
}