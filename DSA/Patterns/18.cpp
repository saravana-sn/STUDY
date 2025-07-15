/*

* * * *
* * *
* *
* 

*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        int k=n;
        while(k>=i){
            cout<<"* ";
            k--;
        }
        cout << "\n";
    }
    return 0;
}