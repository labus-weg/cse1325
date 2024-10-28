#include <iostream>
#include <vector>
#include <string>
#include <cctype>
#include <algorithm>
#include <random>

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
        // Random generator by shuffling
        std::random_device rd;
        std::mt19937 eng(rd());  // Using the  Mersenne Twister algorithm to generate pseudo-random numbers
        std::shuffle(numbers.begin(), numbers.end(), eng);
       
       //sorting
        std::sort(words->begin(), words->end());
        std::cout << "Numbers (shuffled): \n";
        for (const auto& number : numbers) {
            std::cout << number << std::endl;
    }

        std::cout << "Words (sorted): \n";
        for (const auto& word : *words) {
            std::cout << word << std::endl;
    }
    
    return 0;
}

