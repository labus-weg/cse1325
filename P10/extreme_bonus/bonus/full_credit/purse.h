#ifndef PURSE_H
#define PURSE_H

#include <iostream>

class Purse {
private:
    int _pounds, _shillings, _pence;

    void rationalize();

public:
    Purse(int pounds = 0, int shillings = 0, int pence = 0);
    
    friend std::ostream& operator<<(std::ostream& ost, const Purse& purse);
    friend std::istream& operator>>(std::istream& is, Purse& purse);

    bool operator==(const Purse& other) const;
    bool operator!=(const Purse& other) const;
    bool operator<(const Purse& other) const;
    bool operator<=(const Purse& other) const;
    bool operator>(const Purse& other) const;
    bool operator>=(const Purse& other) const;

    Purse& operator++();  
    Purse operator++(int);
    Purse operator+(const Purse& other) const;
    Purse operator-(const Purse& other) const;
    Purse& operator+=(const Purse& other);
    Purse& operator-=(const Purse& other);
};

#endif
