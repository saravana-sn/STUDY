/*

*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int k=0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            char ch = 'A' + k;
            k++;
            cout << ch << " ";
        }
        cout << "\n";
    }
    return 0;
}