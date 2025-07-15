#include <iostream>

class DNA
{
public:
  // 60 000 000 bytes = 60 megabytes
  char code[60'000'000];

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

  Subject(const Subject &other)
      : subject_id(other.subject_id),
        sample(new DNA(*other.sample)) {}

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
  // Subject sheepClone(sheep);
  Subject sheepClone = sheep;
  sheepClone.subject_id = 4;
  sheepClone.printSubjectData();
  sheepClone.sample->code[0] = 'G';
  sheepClone.sample->code[1] = 'C';
  sheep.printSubjectData();
  sheepClone.printSubjectData();
}