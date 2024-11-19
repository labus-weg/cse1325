#include "date.h"
#include <iomanip>
#include <iostream>

Date::Date(int year, int month, int day)
    : _year(year), _month(month), _day(day) {}

std::ostream& operator<<(std::ostream& ost, const Date& date) {
    char old_fill = ost.fill();
    ost << std::setw(4) << date._year << '/'
        << std::setw(2) << std::setfill('0') << date._month << '/'
        << std::setw(2) << date._day;
    ost.fill(old_fill);
    return ost;
}

std::istream& operator>>(std::istream& ist, Date& date) {
    int year, month, day;
    char delimiter1, delimiter2;
    if (ist >> year >> delimiter1 >> month >> delimiter2 >> day &&
        delimiter1 == '/' && delimiter2 == '/' &&
        month >= 1 && month <= 12 &&
        day >= 1 && day <= 31) {
        date = Date(year, month, day);
    } else {
        ist.setstate(std::ios::failbit); // Mark the stream as failed
    }
    return ist;
}
