#include <string>
#include <iostream>


int main() {
    std::string name;
    std::cout << "What's your name? ";
    std::getline(std::cin, name);                        //using getline to read the entire line of chars/strings
    std::cout << "Hello, " << name << "!" << std::endl;
    return 0;
}