#include <iostream>
#include <algorithm>
#include <utility>
#include <array>
#define DNA_CODE_SIZE 60'000'000

class DNA
{
public:
  std::array<char, DNA_CODE_SIZE> code;

  DNA(const char *str)
  {
    for (int i = 0; i < 4; i++)
      code[i] = str[i];
  }

  void printGeneticCode()
  {
    for (int i = 0; i < 4; i++)
      std::cout << code[i];
    std::cout << std::endl;
  }
};

class Subject
{
public:
  int subject_id;
  DNA *sample;

  Subject() : subject_id(0), sample(new DNA("0000")) {}

  Subject(int si, const char *str)
      : subject_id(si), sample(new DNA(str)) {}

  // Copy constructor
  Subject(const Subject &other)
      : subject_id(other.subject_id),
        sample(new DNA(*other.sample))
  {
    std::cout << "Copy constructor" << std::endl;
  }

  // Move constructor
  Subject(Subject &&other) noexcept
      : subject_id(other.subject_id),
        sample(other.sample)
  {
    std::cout << "Move constructor" << std::endl;
    other.subject_id = 0;
    other.sample = nullptr;
  }

  // Copy assignment operator
  Subject &operator=(const Subject &other)
  {
    std::cout << "Copy assignment operator" << std::endl;
    if (this == &other)
      return *this;
    subject_id = other.subject_id;
    sample->code = other.sample->code;
    return *this;
  }

  // Move assignment operator
  Subject &operator=(Subject &&other) noexcept
  {
    std::cout << "Move assignment operator" << std::endl;
    if (this == &other)
      return *this;
    delete sample;
    subject_id = other.subject_id;
    sample = other.sample;

    other.subject_id = 0;
    other.sample = nullptr;
    return *this;
  }

  ~Subject() { delete sample; }

  Subject operator+(const Subject &other)
  {
    int new_subject_id = subject_id + other.subject_id;
    char new_subject_code[4] = {
        sample->code[0],
        sample->code[1],
        other.sample->code[2],
        other.sample->code[3]};
    return Subject(new_subject_id, new_subject_code);
  }

  void printSubjectData()
  {
    std::cout << "ID: " << subject_id << std::endl;
    std::cout << "DNA: ";
    sample->printGeneticCode();
    std::cout << std::endl;
  }
};

int main()
{
}