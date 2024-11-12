#include <iostream>
#include <map>
#include <string>
#include "purse.h"

int main() {
    std::cout << "Welcome to Ye Olde Bank of Merry England\n\n";

    int numAccounts;
    std::cout << "How many accounts? ";
    std::cin >> numAccounts;
    std::cin.ignore();

    std::map<std::string, Purse> vault;

    for (int i = 0; i < numAccounts; ++i) {
        std::string accountName;
        std::cout << "Name account " << i + 1 << ": ";
        std::getline(std::cin, accountName);

        int pounds, shillings, pence;
        std::cout << "Enter your initial deposit (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence;
        std::cin.ignore();

        Purse newAccount(pounds, shillings, pence);
        vault[accountName] = newAccount;

        std::cout << "Account " << accountName << " created with " << newAccount << std::endl;
    }

    std::cout << "\nAccount List\n";
    std::cout << "============\n\n";

    Purse total;
    for (const auto& entry : vault) {
        std::cout << "             " << entry.first << " with " << entry.second << std::endl;
        total += entry.second;
    }

    std::cout << "\nTotal in bank is " << total << std::endl;

    return 0;
}
