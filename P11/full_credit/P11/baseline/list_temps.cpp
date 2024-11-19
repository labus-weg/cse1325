#include <iostream>
#include <fstream>
#include <map>
#include <sstream>
#include "date.h"

typedef double Temp;

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "usage: " << argv[0] << " <data file>\n";
        return 1;
    }

    std::string filename = argv[1];
    std::ifstream infile(filename);

    if (!infile) {
        std::cerr << "Can't open input file " << filename << std::endl;
        return 1;
    }

    std::map<Date, Temp> temps;

    std::string line;
    while (std::getline(infile, line)) {
        std::istringstream stream(line);
        std::string continent, country, state, region;
        int month, day, year;
        double temp;
        char delimiter;

        std::getline(stream, continent, ',');
        std::getline(stream, country, ',');
        std::getline(stream, state, ',');
        std::getline(stream, region, ',');
        stream >> month >> delimiter >> day >> delimiter >> year >> delimiter >> temp;

        Date date(year, month, day);
        temps[date] = temp;
    }

    Date startDate, endDate;
    std::cout << "Starting date to list (year month day): ";
    std::cin >> startDate;
    if (!std::cin) {
        std::cerr << "Invalid input format for starting date.\n";
        return 1;
    }

    std::cout << "Ending date to list (year month day): ";
    std::cin >> endDate;
    if (!std::cin) {
        std::cerr << "Invalid input format for ending date.\n";
        return 1;
    }

    auto it = temps.lower_bound(startDate);
    while (it != temps.end() && it->first <= endDate) {
        std::cout << it->first << " " << it->second << "\n";
        ++it;
    }

    return 0;
}
