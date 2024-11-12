#include "purse.h"
#include <iostream>
#include <stdexcept> // This library handles exceptions/invalid subscript inputs

Purse::Purse(int pounds, int shillings, int pence) 
    : _pounds(pounds), _shillings(shillings), _pence(pence) {
    rationalize();
}

std::ostream& operator<<(std::ostream& os, const Purse& purse) {
    os << "£" << purse._pounds << " " << purse._shillings << "s " << purse._pence << "d";
    return os;
}

std::istream& operator>>(std::istream& is, Purse& purse) {
    char poundSymbol, s, d;
    is >> poundSymbol >> purse._pounds >> purse._shillings >> s >> purse._pence >> d;
    purse.rationalize();
    return is;
}

Purse Purse::operator+(const Purse& other) const {
    return Purse(_pounds + other._pounds, _shillings + other._shillings, _pence + other._pence);
}

Purse& Purse::operator+=(const Purse& other) {
    _pounds += other._pounds;
    _shillings += other._shillings;
    _pence += other._pence;
    rationalize();
    return *this;
}

Purse Purse::operator-(const Purse& other) const {
    return Purse(_pounds - other._pounds, _shillings - other._shillings, _pence - other._pence);
}

int& Purse::operator[](const std::string& subscript) {
    if (subscript == "£") {
        return _pounds;
    } else if (subscript == "s") {
        return _shillings;
    } else if (subscript == "d") {
        return _pence;
    } else if (subscript == "#") {
        return _pounds; 
    } else {
        throw std::invalid_argument("FAIL: Invalid subscript value\n");
    }
}

void Purse::rationalize() {
    _shillings += _pence / 12; 
    _pence %= 12;
    _pounds += _shillings / 20; 
    _shillings %= 20;

    if (_pence < 0) {
        _shillings -= (-_pence + 11) / 12;
        _pence = 12 - (-_pence % 12);
    }

    if (_shillings < 0) {
        _pounds -= (-_shillings + 19) / 20;
        _shillings = 20 - (-_shillings % 20);
    }

        if (_pounds > 100) {
        std::cout << "Wow! You rich! ;-) ;-) Just kidding. Please run me again!! \n";
    }
}
