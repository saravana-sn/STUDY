#include<bits/stdc++.h>
using namespace std;
class A{
    public:
    int height;

};

class B{
    public:
    int weight;
};

class C: public A, public B {

};
int main(){
    C obj;
    cout<<obj.height<<"\n";
    cout << obj.weight << "\n";
    return 0;
}