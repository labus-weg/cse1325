#include "clock.h"

Clock::Clock(int hours, int minutes, int seconds) : _hours(hours), _minutes(minutes), _seconds(seconds) {
    if (hours < 0 || hours > 23) {
        throw std::out_of_range("Invalid hours: " + std::to_string(hours));
    }
    if (minutes < 0 || minutes > 59) {
        throw std::out_of_range("Invalid minutes: " + std::to_string(minutes));
    }
    if (seconds < 0 || seconds > 59) {
        throw std::out_of_range("Invalid seconds: " + std::to_string(seconds));
    }
}

Clock::~Clock() {} 

void Clock::print() const {
    std::cout << std::setfill('0') << std::setw(2) << _hours << ":"
              << std::setfill('0') << std::setw(2) << _minutes << ":"
              << std::setfill('0') << std::setw(2) << _seconds << std::endl;
}

void Clock::tic() {
    _seconds++;
    if (_seconds == 60) {
        _seconds = 0;
        _minutes++;
        if (_minutes == 60) {
            _minutes = 0;
            _hours++;
            if (_hours == 24) {
                _hours = 0;
            }
        }
    }
}
