#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <map>
#include "date.h"
#include <limits>

typedef double Temp;

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cout << "usage: " << argv[0] << " <data file>" << std::endl;
        return 1;
    }

    std::string filename = argv[1];
    std::ifstream file(filename);
    if (!file) {
        std::cout << "Can't open input file " << filename << std::endl;
        return 1;
    }

    std::map<Date, Temp> temps;

    Date startDate, endDate;
    std::cout << "Starting date to list (year month day): ";
    std::cin >> startDate;

    if (!std::cin) {
    std::cerr << "Invalid starting date format. Exiting.\n";
    return 1;
}

    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    std::cout << "Ending date to list (year month day): ";
    std::cin >> endDate;
    
    if (!std::cin) {
    std::cerr << "Invalid ending date format. Exiting.\n";
    return 1;
}


    std::string line;
    std::getline(file, line); 

    while (std::getline(file, line)) {
        std::istringstream stream(line);
        std::string continent, country, state, region;
        int month, day, year;
        Temp temperature;

        std::getline(stream, continent, ',');
        std::getline(stream, country, ',');
        std::getline(stream, state, ',');
        std::getline(stream, region, ',');
        stream >> month;
        stream.ignore(1, ',');  
        stream >> day;
        stream.ignore(1, ',');
        stream >> year;
        stream.ignore(1, ',');
        stream >> temperature;

        Date date(year, month, day);
        temps[date] = temperature;
    }

    file.close();

    for (auto it = temps.lower_bound(startDate); it != temps.upper_bound(endDate); ++it) {
        const Date& date = it->first;
        const Temp& temp = it->second;
        std::cout << date << " " << temp << std::endl;
    }

    return 0;
}
