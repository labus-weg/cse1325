#include <iostream>
#include <ostream>

class Clock {
	public:
		Clock(int hours, int minutes, int seconds)
		: _hours{int}, _minutes{int}, _seconds{int} {
		virtual Clock()	
		}


// #include <iostream>
// #include <ostream>
// class Person {
//  public:
//  Person(std::string name, int id)
//  : _name{name}, _id{id} {
//  notify("Person");
//  }
//  friend std::ostream& operator<<(std::ostream& ost, Person& person);
//  protected:
//  void notify(std::string classname) {
//  std::cout << classname << ' ' << _name << " constructed" << std::endl;
//  }
//  private:
//  std::string _name;
//  int _id;
// };
// std::ostream& operator<<(std::ostream& ost, Person& person) {
//  ost << person._name << " (" << person._id << ')';
//  return ost;