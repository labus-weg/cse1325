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
        std::cin.ignore();
        std::getline(std::cin, accountName);

        std::cout << "Enter your initial deposit (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence;

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
