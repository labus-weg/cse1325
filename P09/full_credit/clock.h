#ifndef CLOCK_H
#define CLOCK_H

#include <iostream>
#include <iomanip>
#include <stdexcept>

class Clock {
public:
    Clock(int hours, int minutes, int seconds);
    virtual ~Clock();
    void print() const;
    void tic();

private:
    int _hours;
    int _minutes;
    int _seconds;
};

#endif
