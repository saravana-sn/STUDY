#include<bits/stdc++.h>
using namespace std;


class Human{
    public:
    int height;
    int weight;
    int age;
    public:
    int getAge(){
        return this->age;
    }

    void setWeight(int w){
        this->weight = w;
    }
};

class Male : protected Human{
    public:
    string color;

    void sleep(){
        cout<<"Male is sleeping\n";
    }

    void setWeight(){
        weight=42;
    }
    
    int getWeight(){
        return weight;
    }
};
int main(){

    


    //inheritance

    Male m1;
    m1.setWeight();
    cout<<m1.getWeight()<<"\n";

    // cout<<m1.age<<"\n";
    // cout << m1.color << "\n";
    // cout << m1.weight << "\n";
    // m1.sleep();

    // m1.setWeight(42);

    // cout << m1.weight << "\n";

    return 0;
}