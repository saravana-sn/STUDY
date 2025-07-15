#include<iostream>
using namespace std;

int main(){
    int n;
    cin>>n;

    //How many rows - n
    // How many columns - n+i-1
    //Pattern
    //    - Spaces on columns that are <n-i
    //    - Increasing numbers on [n-i+1,n] 
    //    - remaining columns - decreasing numbers. 

    for(int i=1; i<=n;i++){

        //First loop for spaces(n-i)
        int spaces = 1;
        while(spaces<=n-i){
            cout<<" ";
            spaces++;
        }
        
        //for right half (incrementing temp)
        int temp =i;
        for(int j=1;j<=i;j++){
            
            cout<<temp;
            temp++;

        }

        //for left half (decrementing temp)
        temp--;
        for(int k=1;k<i;k++){
            temp--;
            cout<<temp;
            
        }
        cout << "\n";
    }
    return 0;
}

/* OUTPUT

5
    1
   232
  34543
 4567654
567898765

*/