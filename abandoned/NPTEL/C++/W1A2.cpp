#include<iostream>
#include<bits/stdc++.h>
#include<string.h>
using namespace std;

bool compare (char c1,char c2){
    return(c1>c2);
}

int main(){

   vector<char> v;
   char a;
   cout<<"Enter the charcters: ";
   for (int i = 0; i < 5; i++)
   {
       cin >> a;
       v.push_back(a);
   }

   sort(&v[0],&v[4],compare);

   for(int i=0;i<5;i++){
       cout<<v[i]<<" ";
   }

    return 0;
}