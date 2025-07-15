#include <iostream>
#include <algorithm>
#include <utility>
#include <array>
#include <memory>
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
  std::unique_ptr<DNA> sample;

  Subject() : subject_id(0), sample(std::make_unique<DNA>("0000"))
  {
    std::cout << "Default constructor" << std::endl;
  }

  Subject(int si, const char *str)
      : subject_id(si), sample(std::make_unique<DNA>(str))
  {
    std::cout << "Parameterized constructor" << std::endl;
  }

  // Copy constructor
  Subject(const Subject &other)
      : subject_id(other.subject_id),
        sample(std::make_unique<DNA>(*other.sample))
  {
    std::cout << "Copy constructor" << std::endl;
  }

  // Move constructor
  Subject(Subject &&other) noexcept
      : subject_id(other.subject_id),
        sample(std::move(other.sample))
  {
    std::cout << "Move constructor" << std::endl;
    other.subject_id = 0;
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
    subject_id = other.subject_id;
    sample = std::move(other.sample);

    other.subject_id = 0;
    return *this;
  }

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