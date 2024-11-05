#include "clock.h"

int main(int argc, char* argv[]) {
    if (argc != 4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return EXIT_FAILURE;
    }

    try {

        int hours = std::stoi(argv[1]); //this converts cmd line arg to int since they're always entered as strings
        int minutes = std::stoi(argv[2]);
        int seconds = std::stoi(argv[3]);

        Timer timer(hours, minutes, seconds); //Timer instance is created
        // Loop
        std::string user_input;
        while (true) {
            clock.print(); // Print the current time
            std::cout << "Press enter to increment time OR type 'q' to quit: ";
            std::getline(std::cin, user_input);
            if (user_input == "q") break;

            clock.tic();
        }
    } catch (const std::out_of_range& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return EXIT_FAILURE;
    } catch (const std::exception& e) {
        std::cerr << "An unexpected error occurred: " << e.what() << std::endl;
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}
