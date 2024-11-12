CXX = g++
CXXFLAGS += -std=c++2a -Wall -g

bank: bank.o purse.o
	$(CXX) $(CXXFLAGS) bank.o purse.o -o bank

bank.o: bank.cpp purse.h
	$(CXX) $(CXXFLAGS) -c bank.cpp -o bank.o

purse.o: purse.cpp purse.h
	$(CXX) $(CXXFLAGS) -c purse.cpp -o purse.o

test_full_credit: test_full_credit.o purse.o
	$(CXX) $(CXXFLAGS) test_full_credit.o purse.o -o test_full_credit

test_full_credit.o: test_full_credit.cpp purse.h
	$(CXX) $(CXXFLAGS) -c test_full_credit.cpp -o test_full_credit.o

all: bank test_full_credit

clean:
	-rm -f *.o *.gch *~ bank test_full_credit
