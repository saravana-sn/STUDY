#include<iostream>
using namespace std;

int main(){
    int n;
    cin>>n;

    for(int i=1;i<=n;i++){
       
            int spaces =1;
          while(spaces<=n-i){
              cout<<" ";
              spaces++;
          }

          for (int j = 1; j <= i; j++)
          {
                  cout << i + j - 1;
          }
      cout<<"\n";
    }
    return 0;
}

// 4
//    1
//   23
//  345
// 4567