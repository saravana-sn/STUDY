#include <bits/stdc++.h>
using namespace std;
int main()
{

    // #1
    int n, res = 0;
    cin >> n;
    int dup = n;
    while (n > 0)
    {
        res *= 10;
        res += n % 10;
        n /= 10;
    }
    
    if (dup==res) cout<<"true";
    else cout << "false";

    return 0;
}