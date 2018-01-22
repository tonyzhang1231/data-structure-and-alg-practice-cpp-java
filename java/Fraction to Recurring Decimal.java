// 166. Fraction to Recurring Decimal   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 44272
// Total Submissions: 263818
// Difficulty: Medium
// Contributors: Admin
// Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

// If the fractional part is repeating, enclose the repeating part in parentheses.

// For example,

// Given numerator = 1, denominator = 2, return "0.5".
// Given numerator = 2, denominator = 1, return "2".
// Given numerator = 2, denominator = 3, return "0.(6)".
// Hint:

// No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
// Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
// Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.
// Credits:
// Special thanks to @Shangrila for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Hash Table Math


public class Solution {
    public String fractionToDecimal(int num, int den) {
        StringBuilder res = new StringBuilder();
        // overflow d==0 or n = min_value  && d = -1
        boolean isNeg = (num>0 && den<0) || (num<0 && den>0);
        long n = Math.abs((long) num);
        long d = Math.abs((long) den);

        
        if (isNeg) res.append('-');
        res.append(n/d);
        long r = n%d;
        if (r==0) return res.toString();
        res.append('.');

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(r,res.length()); // put inital remaining
        while(r!=0){
        	r = r*10;
        	res.append(r/d);
        	r = r%d;  // update remaining
        	if (map.containsKey(r)) break; // if new remaining is in the map, break
        	map.put(r,res.length());
        }

        if (r==0) return res.toString();

        res.insert(map.get(r),"(");
        res.append(')');
        return res.toString();
        

    }
}

// 2/3   
// res = 0.6
// map     2
// r = 

// 1/11
// res = 0.0 9
// map =   1 10
// r = 10


// 2/3   20/3 6 2 
// r = 200%3= 2
// 1/110   .0(09)090909 //  0 -> 10   0->100   9 -> 1000  -> 10
// 1/300  .00303030303
//        .003003003003