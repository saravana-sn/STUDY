/*
1 1 1 1
  2 2 2
    3 3
      4
*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if(j<i)
                cout<<"  ";
            else
                cout<<i<<" ";
        }
        cout << "\n";
    }
    return 0;
}