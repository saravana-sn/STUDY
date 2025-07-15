#include <iostream>
#include <algorithm>
#define DNA_CODE_SIZE 60'000'000

class DNA
{
public:
  // 60 000 000 bytes = 60 megabytes
  char code[DNA_CODE_SIZE];

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
        sample(new DNA(*other.sample)) {}

  // Subject sub1(5, "CGTA"), sub2, sub3;
  // sub2 = sub3 = sub1;
  // sub2.operator=(sub3.operator=(sub1));
  // Copy assignment operator
  Subject &operator=(const Subject &other)
  {
    if (this == &other)
      return *this;
    subject_id = other.subject_id;
    std::copy(
        other.sample->code,
        other.sample->code + DNA_CODE_SIZE,
        sample->code);

    // This would also work instead of std::copy()
    // delete sample;
    // sample = new DNA(*other.sample);

    return *this;
  }

  ~Subject() { delete sample; }

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
  Subject sheep(3, "CGTA");
  sheep.printSubjectData();
  Subject sheepClone;
  // sheepClone.operator=(sheep);
  sheepClone = sheep;
  sheepClone.subject_id = 4;
  sheepClone.printSubjectData();
  sheepClone.sample->code[0] = 'G';
  sheepClone.sample->code[1] = 'C';
  sheep.printSubjectData();
  sheepClone.printSubjectData();
}