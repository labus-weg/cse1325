#include <iostream>
#include <map>
#include <string>
#include "purse.h"

int main() {
    std::map<std::string, Purse> vault;

    int numAccounts;
    std::cout << "How many accounts do you want to create? ";
    std::cin >> numAccounts;
    std::cin.ignore();

    for (int i = 0; i < numAccounts; ++i) {
        std::string accountName;
        int pence, shillings, pounds;

        std::cout << "Enter account name: ";
        std::getline(std::cin, accountName);

        std::cout << "Enter the initial deposit (pence, shillings, pounds): ";
        std::cin >> pence >> shillings >> pounds;
        std::cin.ignore();

        vault[accountName] = Purse(pence, shillings, pounds);
    }

    Purse total;
    for (const auto& entry : vault) {
        std::cout << entry.first << ": " << entry.second << std::endl;
        total += entry.second;
    }

    std::cout << "Total amount in the bank: " << total << std::endl;

    return 0;
}
