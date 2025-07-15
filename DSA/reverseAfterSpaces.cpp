#include <iostream>
#include <string>
using namespace std;

int main(){
    string s;
    getline(cin,s);
    int l=0;

    for(int i=0;i<s.length();i++){
        if (s[i] == ' ')
        {
            reverse(begin(s)+l,begin(s)+i);
            l=i+1;
        }
        if(i == s.length() - 1){
            reverse(begin(s) + l, begin(s) + i+1);
        }
    }
    cout<<s;
    return 0;
}