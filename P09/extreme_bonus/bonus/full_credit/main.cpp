#include "timer.h"
#include <iostream>
#include <stdexcept>

int main(int argc, char* argv[]) {
    if (argc != 4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return EXIT_FAILURE;
    }

    try {
        int hours = std::stoi(argv[1]);
        int minutes = std::stoi(argv[2]);
        int seconds = std::stoi(argv[3]);

        Timer timer(hours, minutes, seconds); 
        // Loop
        std::string user_input;
        while (true) {
            timer.print();
            std::cout << "Press enter to increment time OR type 'q' to quit: ";
            std::getline(std::cin, user_input);
            if (user_input == "q") break;

            timer.tic();
        }
    } catch (const std::out_of_range& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return EXIT_FAILURE;
    } catch (const std::runtime_error& e) {
        std::cerr << "Timer expired: " << e.what() << std::endl;
        return EXIT_SUCCESS; 
    } catch (const std::exception& e) {
        std::cerr << "An unexpected error occurred: " << e.what() << std::endl;
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
