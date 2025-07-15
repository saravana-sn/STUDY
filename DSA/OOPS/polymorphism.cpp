#include<bits/stdc++.h>
using namespace std;

class A{
    public:
    void sayHello(){
        cout<<"Hello,Saravana\n";
    }

    //overloaded function
    void sayHello(int n){
        cout<<"Hello\n";
    }
};
int main(){
    A c;
    c.sayHello(5);

    return 0;
}