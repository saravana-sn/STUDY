#include <iostream>

class Instrument
{
public:
  bool electric;

  Instrument() : electric(false) {}
  Instrument(bool el) : electric(el) {}
  void play()
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
  void play()
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
  void play()
  {
    std::cout << "Synth sound with "
              << num_of_keys << " keys." << std::endl;
  }
};

int main()
{
  Instrument i;
  Guitar g1(true);
  Guitar g2(7);
  Synth s(25);

  i.play();
  g1.play();
  g2.play();
  s.play();
}