#ifndef DATE_H
#define DATE_H

#include <iostream>

class Date {
private:
    int _year, _month, _day;

    bool validate(int year, int month, int day) const;

public:
    Date(int year = 1970, int month = 1, int day = 1);

    inline bool operator==(const Date& other) const {
        return _year == other._year && _month == other._month && _day == other._day;
    }

    inline bool operator!=(const Date& other) const {
        return !(*this == other);
    }

    inline bool operator<(const Date& other) const {
        if (_year != other._year) return _year < other._year;
        if (_month != other._month) return _month < other._month;
        return _day < other._day;
    }

    inline bool operator<=(const Date& other) const {
        return *this < other || *this == other;
    }

    inline bool operator>(const Date& other) const {
        return !(*this <= other);
    }

    inline bool operator>=(const Date& other) const {
        return !(*this < other);
    }

    friend std::ostream& operator<<(std::ostream& ost, const Date& date);
    friend std::istream& operator>>(std::istream& ist, Date& date);

    bool isValid() const;


};

#endif