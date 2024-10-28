#include <iostream>
#include <vector>
#include <string>
#include <cctype> 

int main(int argc, char* argv[]) {
    std::vector<std::string> numbers; // On stack
    std::vector<std::string>* words = new std::vector<std::string>; // On heap

for (int i = 1; i < argc; ++i) {
    std::string arg = argv[i];
    if (isdigit(arg[0])) {
        numbers.push_back(arg);
    } else {
        words->push_back(arg);
    }
}
        std::cout << "Numbers: \n";
        for (const auto& number : numbers) {
            std::cout << number << std::endl;
        }

        std::cout << "Words: \n";
        for (const auto& word : *words) {
            std::cout << word << std::endl;
        }

        delete words;

        return 0;
}