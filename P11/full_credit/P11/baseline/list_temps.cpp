#include <iostream>
#include <fstream>
#include <sstream>
#include <map>
#include <string>
#include "date.h"

typedef double Temp;

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "usage: " << argv[0] << " <data file>" << std::endl;
        return 1;
    }

    std::string filename = argv[1];

    std::ifstream file(filename);
    if (!file) {
        std::cerr << "Can't open input file " << filename << std::endl;
        return 1;
    }

    std::map<Date, Temp> temps;
    std::string line;

    std::getline(file, line);

    while (std::getline(file, line)) {
        std::stringstream ss(line);
        std::string continent, country, state, region;
        int month, day, year;
        double temperature;

        std::getline(ss, continent, ',');
        std::getline(ss, country, ',');
        std::getline(ss, state, ',');
        std::getline(ss, region, ',');

        ss >> month;
        ss.ignore(1, ',');
        ss >> day;
        ss.ignore(1, ',');
        ss >> year;
        ss.ignore(1, ',');
        ss >> temperature;

        Date date(year, month, day);

        temps[date] = temperature;
    }

    file.close();

    Date startDate, endDate;
    std::cout << "Starting date to list (year month day): ";
    std::cin >> startDate;
    std::cout << "Ending date to list (year month day): ";
    std::cin >> endDate;

    for (auto it = temps.lower_bound(startDate); it != temps.upper_bound(endDate); ++it) {
        const Date& date = it->first;
        Temp temp = it->second;

        std::cout << date << " " << temp << " °F" << std::endl;
    }

    return 0;
}
