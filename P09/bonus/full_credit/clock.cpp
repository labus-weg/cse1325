#include "clock.h"
#include <cstdlib> 
// Constructor
Clock::Clock(int hours, int minutes, int seconds) 
    : _hours(hours), _minutes(minutes), _seconds(seconds) {
    if (_hours < 0 || _hours > 23) {
        throw std::out_of_range("Invalid hours. Range is between 0 & 23: " + std::to_string(hours));
    }
    if (_minutes < 0 || _minutes > 59) {
        throw std::out_of_range("Invalid minutes. Range is between 0 & 59: " + std::to_string(minutes));
    }
    if (_seconds < 0 || _seconds > 59) {
        throw std::out_of_range("Invalid seconds. Range is between 0 & 59: " + std::to_string(seconds));
    }
}

// Destructor
Clock::~Clock() {}

// Print method
void Clock::print() const {
    std::cout << std::setfill('0') << std::setw(2) << _hours << ":"
              << std::setfill('0') << std::setw(2) << _minutes << ":"
              << std::setfill('0') << std::setw(2) << _seconds << std::endl;
}


// Increment method
void Clock::tic() {
    _seconds++;
    if (_seconds >= 60) {
        _seconds = 0;
        _minutes++;
        if (_minutes >= 60) {
            _minutes = 0;
            _hours++;
            if (_hours >= 24) {
                _hours = 0;
            }
        }
    }
}
