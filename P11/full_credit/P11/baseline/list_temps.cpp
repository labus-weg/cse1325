#include <iostream>
#include <fstream>
#include <sstream>
#include <map>
#include <iomanip>
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
        std::cerr << "Can't open input file " << filename << "\n";
        return 1;
    }

    std::map<Date, Temp> temps;
    std::string line;

    while (std::getline(infile, line)) {
        std::istringstream ss(line);
        std::string continent, country, state, region, month_str, day_str, year_str, temp_str;

        std::getline(ss, continent, ',');
        std::getline(ss, country, ',');
        std::getline(ss, state, ',');
        std::getline(ss, region, ',');
        std::getline(ss, month_str, ',');
        std::getline(ss, day_str, ',');
        std::getline(ss, year_str, ',');
        std::getline(ss, temp_str, ',');

        int month = std::stoi(month_str);
        int day = std::stoi(day_str);
        int year = std::stoi(year_str);
        double temperature = std::stod(temp_str);

        temps[Date(year, month, day)] = temperature;
    }

    while (std::cin.good()) {
        int start_year, start_month, start_day;
        int end_year, end_month, end_day;

        std::cout << "Enter starting date (YYYY MM DD): ";
        std::cin >> start_year >> start_month >> start_day;
        if (!std::cin.good()) break;

        std::cout << "Enter ending date (YYYY MM DD): ";
        std::cin >> end_year >> end_month >> end_day;
        if (!std::cin.good()) break;

        Date start_date(start_year, start_month, start_day);
        Date end_date(end_year, end_month, end_day);

        auto it = temps.lower_bound(start_date);
        std::cout << std::setw(10) << "Date" << std::setw(10) << "Temp (°F)\n";
        std::cout << "----------------------\n";

        while (it != temps.end() && it->first <= end_date) {
            std::cout << std::setw(10) << it->first << std::setw(10) << it->second << "\n";
            ++it;
        }
    }

    return 0;
}
