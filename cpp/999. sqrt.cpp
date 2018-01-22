#include "000LCHeader.h"

using namespace std;

// https://www.codeproject.com/Articles/69941/Best-Square-Root-Method-Algorithm-Function-Precisi

// Algorithm: Babylonian Method
double sqrt9( const double fg)
{ 
	double n = fg / 2.0;
	double lstX = 0.0; 
	while(n != lstX)  
	{ 
		cout << n << endl;
		lstX = n;
		n = (n + fg/n) / 2.0; // x[n+1]  = 0.5 * (xn + S/xn) 
	}
	return n;
}  


int main(){
	cout << sqrt9(1232345.21341234123) << '\n';
}

// g++ -std=c++14 999.\ sqrt.cpp -o out.o