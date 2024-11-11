#include "Purse.h"

Purse::Purse(int pounds, int shillings, int pence) 
    : _pounds(pounds), _shillings(shillings), _pence(pence) {
    rationalize();
    ensureNonNegative();  // Ensure non-negative values on initialization
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse) {
    ost << "£" << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
    return ost;
}

Purse& Purse::operator++() {
    _pence++;
    rationalize();
    ensureNonNegative();  // Ensure non-negative values after increment
    return *this;
}

Purse Purse::operator++(int) {
    Purse temp = *this;
    ++(*this);
    return temp;
}

Purse Purse::operator+(const Purse& other) const {
    return Purse(_pounds + other._pounds, _shillings + other._shillings, _pence + other._pence);
}

Purse Purse::operator-(const Purse& other) const {
    int newPounds = _pounds - other._pounds;
    int newShillings = _shillings - other._shillings;
    int newPence = _pence - other._pence;

    // Ensure that subtraction doesn't result in negative values
    if (newPounds < 0 || newShillings < 0 || newPence < 0) {
        std::cerr << "Error: Cannot have negative amounts in the purse.\n";
        return Purse(0, 0, 0);  // Returning a default purse if something goes negative
    }
    return Purse(newPounds, newShillings, newPence);
}

Purse& Purse::operator+=(const Purse& other) {
    _pounds += other._pounds;
    _shillings += other._shillings;
    _pence += other._pence;
    rationalize();
    ensureNonNegative();  // Ensure non-negative values after addition
    return *this;
}

Purse& Purse::operator-=(const Purse& other) {
    _pounds -= other._pounds;
    _shillings -= other._shillings;
    _pence -= other._pence;

    // If any of the fields become negative, revert the changes and print an error
    if (_pounds < 0 || _shillings < 0 || _pence < 0) {
        std::cerr << "Error: Cannot have negative amounts in the purse.\n";
        // Rollback operation
        _pounds += other._pounds;
        _shillings += other._shillings;
        _pence += other._pence;
    } else {
        rationalize();
    }

    ensureNonNegative();  // Ensure non-negative values after compound subtraction
    return *this;
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

void Purse::ensureNonNegative() {
    // Ensure that there are no negative values
    if (_pounds < 0) _pounds = 0;
    if (_shillings < 0) _shillings = 0;
    if (_pence < 0) _pence = 0;
}
