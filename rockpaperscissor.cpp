#include <iostream>
#include <conio.h>
#include <cstdlib>
#include <ctime>
using namespace std;

int main(){

    int computerChoice, userChoice;
    char choice;

    srand(time(NULL));
    computerChoice = (rand() % 3) + 1;

    

    cout<<"-----Welcome To Rock Paper Scissor Game-----"<<endl;
    do{
    cout<<"Option:"<<endl;
    cout<<"1.Rock"<<endl<<"2.Paper"<<endl<<"3.scissors"<<endl;
    cout<<"Your choice:";
    cin>>userChoice;
    cout<<"Computer choice:";

    switch (computerChoice){
        case 1: cout<<"Rock"<<endl;
        break;
        case 2: cout<<"Paper"<<endl;
        break;
        case 3: cout<<"scissor"<<endl;
    }
   
    if((userChoice == 2 && computerChoice == 1)||
       (userChoice == 3 && computerChoice == 2)||
       (userChoice == 1 && computerChoice == 3)){
        cout<<"You Win!!"<<endl;
    }
    else if(userChoice == computerChoice){
        cout<<"Its Draw!!"<<endl;
    }
    else{
        cout<<"Computer Won!!"<<endl;
    }

    cout<<"Do you want to try again? Y/N"<<endl;
    cin>>choice;
   }
   while(choice == 'Y' || choice == 'y');

    return 0;
}