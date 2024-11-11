#include <iostream>
#include <map>
#include "Purse.h"

int main() {
    std::map<std::string, Purse> vault;
    int numAccounts;

    std::cout << "Welcome to Ye Olde Bank of Merry England\n";
    std::cout << "How many accounts? ";
    std::cin >> numAccounts;

    for (int i = 0; i < numAccounts; ++i) {
        std::string accountName;
        int pounds, shillings, pence;

        std::cout << "Name account " << i << ": ";
        std::cin.ignore();  // To clear the input buffer before using getline
        std::getline(std::cin, accountName);

        std::cout << "Enter your initial deposit (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence;

        // Check for valid deposit amounts
        if (pounds < 0 || shillings < 0 || pence < 0) {
            std::cerr << "Error: Deposit amounts cannot be negative. Account creation failed.\n";
            continue;  // Skip creating this account
        }

        vault[accountName] = Purse(pounds, shillings, pence);
        std::cout << "Account " << accountName << " created with " << vault[accountName] << "\n";
    }

    std::cout << "\nAccount List\n============\n";
    Purse total;
    for (const auto& [name, purse] : vault) {
        std::cout << "  " << name << " with " << purse << "\n";
        total += purse;
    }

    std::cout << "\nTotal in bank is " << total << "\n";
    return 0;
}
