#include <bits/stdc++.h>
using namespace std;
int main(){

    //#1
    int n, res = 0;
    cin>>n;
    // while(n>0){
    //     cout<<n%10<<res<<endl;
    //     n/=10;
    //     res++;
    // }
    // cout<<res;

    //#2
    cout<< (int) (log10(n) +1);

    //TC = log10(N)
    //whenever we do division inside loop log comes into picture. N/x / TC = logx(N).


    return 0;
}