
// single number I

// for any number a^a = 0;
// ^ = XOR

public class Solution {
	int singleNumber(int A[]) {
	    int result = 0;
	    for (int a:A)
	    {
			result ^=a;
	    }
		return result;
	}
}

// O(n) time, O(1) space;


// single number II

// Given an array of integers, every element appears three times except for one, 
// which appears exactly once. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. 
// Could you implement it without using extra memory?

public class Solution {
    public int singleNumber2(int[] A) {
    	// int[] bits = new int[32];
    	int res = 0;
    	for (int i = 0;i<32;i++){
    		int temp = 0;
    		for (int a:A){
    			temp += (a>>i) & 1;
    		}
    		temp = temp%3;
    		res += temp<<i;
    	}
    	return res;
    }
}

// test case: 11  11  11  10  10  10  01

// O(32n) time, O(1) space;


// single number III
260. Single Number III   
// Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

// Note:
// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question


// xor = a^b
// xor & ~(xor-1)  return   00001000, where 1 is the last place that a and b have different bit

// for example: a = .....1abc,  b = .....0abc   => xor = a^b = .....1000 => xor -1 = .....0111
// then ~xor = ~(.....)1000 => bit = xor & ~(xor-1) = 000001000
// then a&bit >0,  b&bit=0

public class Solution {
    public int[] singleNumber(int[] A) {
    	int xor = 0;
        for (int a:A){
        	xor ^= a;
        }
        int bit = xor & ~(xor-1); // bit = xor & -xor
        int num1 = 0,num2 = 0;
        for (int a:A){
        	if ( (a & bit)==0){     // & has lower priority than ==
        		num1^=a;
        	}else{
        		num2^=a;
        	}
        }
        return new int[]{num1,num2};
    }
}

// O(n) time and O(1) space
