#include<iostream>
#include<bits/stdc++.h>
using namespace std;

void F(vector<int> &arr,vector<int> &ds,int n, int i){
    if(i==n){
        for(int i=0;i<ds.size();i++){
            cout<<ds[i]<<" ";
        }
        cout<<endl;
        return;
    }
    F(arr,ds,n,i+1);
    ds.push_back(arr[i]);
    F(arr,ds,n,i+1);
    ds.pop_back();

}
int main(){
    vector<int> arr={3,1,2,4};
    vector<int> ds;
    int n=arr.size();
    F(arr,ds,n,0);
    return 0;
}