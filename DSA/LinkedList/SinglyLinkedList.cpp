#include<iostream>
using namespace std;

class Node{
    public:
    int data;
    Node* next;

    //Parametarised constructor
    Node(int data){
        this->data=data;
        this->next=NULL;
    }

    //Default constructor
    Node(){
        this->data=0;
        this->next=NULL;
    }
};

class Node1{
    public:
    int data;
    Node1 newNode1();

    

}

int main(){

    Node* node = new Node(9);
    cout<< node->data<<endl;
    cout<< node->next<<endl;

    Node1 newNode1 = 5;
    cout << node1.data << endl;
    cout << node1.next << endl;
}