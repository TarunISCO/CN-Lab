#include <iostream>
#include <string>
using namespace std;

int main()
{
    string address;
    cout<<"Enter the Address : ";
    cin>>address;
    cout<<endl;
    string first_byte = address.substr(0, address.find('.'));
    int n = stoi(first_byte);
    if(n >= 1 && n <= 126)
        cout<<"Class 1"<<endl;
    else if(n >= 128 && n <= 191)
        cout<<"Class 2"<<endl;
    else if(n >= 192 && n <= 239)
        cout<<"Class 3"<<endl;
    else if(n >= 240 && n <= 255)
        cout<<"Class 4"<<endl;
    else
        cout<<"Wrong Address!!!";
    return 0;
}
