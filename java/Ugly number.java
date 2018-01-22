ugly number


// Write a program to check whether a given number is an ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

// Note that 1 is typically treated as an ugly number.


ugly number I

public class Solution {
	public boolean isUgly(int num) {
	    if(num==1) return true;
	    if(num==0) return false;
		while(num%2==0) num=num>>1;
		while(num%3==0) num=num/3;
		while(num%5==0) num=num/5;
	    return num==1;
	}
}


// ugly number II
public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}

// O(n) time and O(n) space

// 1      
// 235

// 1   2
// 35  2
..
//  1    2    3    4   5    6   8
//       5    3        2

ugly number III
O(nk) time and O(n) + O(k) space
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
    }
}

// use a for loop to get the min, and use another for loop to move the index

