#include<iostream>
#include <conio.h>
using namespace std;

class BankAccount{
private:
    int AccNumber;
    string AccHolderName;
    int Balance;

public:
    void setAccNumber(int accnum){
        AccNumber = accnum;
    }
    int getAccNumber(){
        return AccNumber;
    }
    void setAccHolderName(string accname){
        AccHolderName = accname;
    }
    string getAccHolderName(){
        return AccHolderName;
    }
    void setBalance(int bal){
        Balance = bal;
    }
    int getBalance(){
        return Balance;
    }

    void deposit(){
        int amount;
        cout<<"enter amount to deposit : "<<endl;
        cin>>amount;
        Balance = Balance + amount;
    }

    void withdraw(){
        int amount;
        cout<<"Enter the amount to be withdrawn : "<<endl;
        cin>>amount;
        if (amount < Balance && amount > 0){
        Balance = Balance - amount;
        }
        else{
            cout<<"not enough balance";
        }
    }

    void display(){
        cout<<"Account Details: "<<endl;
        cout<<"Account Number: "<<AccNumber<<endl;
        cout<<"Account Holder Name: "<<AccHolderName<<endl;
        cout<<"Current Balance: "<<Balance<<endl;
    }

    BankAccount(int accnum,string accname,int bal){
        AccNumber = accnum;
        AccHolderName = accname;
        Balance = bal;
    }
};

int main(){

    int num;

    BankAccount acc1(21,"aisha",200);
    cout<<"Select from following: "<<endl;
    cout<<"1.deposit amount "<<endl;
    cout<<"2.withdraw amount "<<endl;
    cin>>num;
    if(num==1){
    acc1.deposit();
    acc1.display();
    }
    else if(num==2){
        acc1.withdraw();
        acc1.display();
    }
    else{
        cout<<"Invalid input";
    }
}