#include <iostream>

class Instrument
{
public:
  bool electric;

  Instrument() : electric(false) {}
  Instrument(bool el) : electric(el) {}
  virtual void play() = 0;
  virtual ~Instrument() = default;
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

void check_electricity(Instrument *instrument)
{
  if (instrument->electric)
    std::cout << "This one needs to be plugged in!" << std::endl;
}

int main()
{
  // Instrument *i = new Instrument();
  // Instrument *g1 = new Guitar(true);
  // Instrument *g2 = new Guitar(7);
  // Instrument *s = new Synth(25);

  // i->play();
  // g1->play();
  // g2->play();
  // s->play();

  // delete i;
  // delete g1;
  // delete g2;
  // delete s;

  Instrument *band[3] = {
      new Guitar(true),
      new Guitar(7),
      new Synth(25)};

  for (int i = 0; i < 3; i++)
  {
    band[i]->play();
    check_electricity(band[i]);
  }

  for (int i = 0; i < 3; i++)
    delete band[i];
}