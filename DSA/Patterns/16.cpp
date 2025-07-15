/*
D
C D
B C D
A B C D
*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            char ch = 'A' + j-i+n-1;
            cout << ch << " ";
        }
        cout << "\n";
    }
    return 0;
}