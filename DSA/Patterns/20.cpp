/*
      1
    1 2 1
  1 2 3 2 1
1 2 3 4 3 2 1
*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        int k = 1;
        for (int j = 1; j <= n; j++)
        {
            while (i + j <= n)
            {
                cout << "  ";
                j++;
            }
            if (j <= n)
            {
                cout << k++ << " ";
            }
        }
        int l = k;
        l -= 2;
        while (l > 0)
        {
            cout << l-- << " ";
        }
        cout << "\n";
    }
    return 0;
}