#include<iostream>
#include<string.h>
using namespace std;

int main(){
    string str1,str2;
    cout<<"Enter the string :";
    cin>>str1>>str2;

    if(str1.size()>str2.size()){
        cout<< str1 <<" is greater";
    }
    else if (str1.size() < str2.size())
    {
        cout<<str2<<" is greater";
    }
    else
        cout << "strings are equal";

    return 0;
}

/* output

Enter the string :crow cow cow zebra
crow is greater

Enter the string :crow crow
strings are equal

Enter the string :apple  orange
orange is greater

Enter the string :house home
house is greater

*/