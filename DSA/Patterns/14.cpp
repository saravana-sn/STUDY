/*
A
B C
D E F
G H I J
*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int k=1;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            char ch = 'A' + k - 1;
            k++;
            cout << ch << " ";
        }
        cout << "\n";
    }
    return 0;
}