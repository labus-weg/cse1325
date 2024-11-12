#include "purse.h"
#include <iostream>

Purse::Purse(int pounds, int shillings, int pence) : _pence(pence), _shillings(shillings), _pounds(pounds) {
    rationalize();
}


void Purse::rationalize() {
    if (_pence >= 12) {
        _shillings += _pence / 12;
        _pence %= 12;
    }
    if (_shillings >= 20) {
        _pounds += _shillings / 20;
        _shillings %= 20;
    }
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse) {
    ost << "£" << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
    return ost;
}

// Comparison operators (manual implementation)
bool Purse::operator==(const Purse& other) const {
    return (_pounds == other._pounds) && (_shillings == other._shillings) && (_pence == other._pence);
}

bool Purse::operator!=(const Purse& other) const {
    return !(*this == other);
}

bool Purse::operator<(const Purse& other) const {
    if (_pounds != other._pounds) return _pounds < other._pounds;
    if (_shillings != other._shillings) return _shillings < other._shillings;
    return _pence < other._pence;
}

bool Purse::operator<=(const Purse& other) const {
    return (*this < other) || (*this == other);
}

bool Purse::operator>(const Purse& other) const {
    return !(*this <= other);
}

bool Purse::operator>=(const Purse& other) const {
    return !(*this < other);
}

Purse& Purse::operator++() {
    ++_pence;
    rationalize();
    return *this;
}

Purse Purse::operator++(int) {
    Purse temp = *this;
    ++*this;
    return temp;
}

Purse Purse::operator+(const Purse& other) const {
    return Purse(_pounds + other._pounds, _shillings + other._shillings, _pence + other._pence);
}

Purse Purse::operator-(const Purse& other) const {
    return Purse(_pounds - other._pounds, _shillings - other._shillings, _pence - other._pence);
}

Purse& Purse::operator+=(const Purse& other) {
    _pounds += other._pounds;
    _shillings += other._shillings;
    _pence += other._pence;
    rationalize();
    return *this;
}

Purse& Purse::operator-=(const Purse& other) {
    _pounds -= other._pounds;
    _shillings -= other._shillings;
    _pence -= other._pence;
    rationalize();
    return *this;
}
