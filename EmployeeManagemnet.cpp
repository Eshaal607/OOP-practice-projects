#include<iostream>
using namespace std;
class abstractemployee{
    virtual void askforpromotion()=0;
};
class employee:public abstractemployee{
private:
    string name;
    string company;
    int age;
public:  
   void setname(string Name){
    name = Name;
   }
   string getname(){
    return name;
   }
   void setcompany(string Company){
    company = Company;
   }
   string getcompany(){
    return company;
   }
   void setage(int Age){
    age = Age;
   }
   int getage(){
    return age;
   }

    void display(){
        cout<<"Name : "<<name<<endl;
        cout<<"Company : "<<company<<endl;
        cout<<"Age : "<<age<<endl;
    }
    void askforpromotion()  {
        if(age>30){
            cout<<"you are promoted"<<endl;
        }
        else{
            cout<<"no promotion for you"<<endl;
        }
        }
    
    employee(string Name,string Company,int Age){
        name=Name;
        company= Company;
        age=Age;
    };

};

class programmer:public employee{
public:
        string favproglang;
        programmer(string Name,string Company,int Age,string Favproglang)
            :employee(Name,Company,Age){
                favproglang = Favproglang;
            }
        void language(){
            cout<<"fav language is : "<<favproglang;
        }
};

int main(){
    employee employee1("eshaal","amazon",45);
    employee1.display();
    employee1.askforpromotion();
    programmer p1("eshaal","amazon",22,"cpp");
    p1.language();
    
}