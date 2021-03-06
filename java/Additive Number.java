// 306. Additive Number   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 20119
// Total Submissions: 74052
// Difficulty: Medium
// Contributors: Admin
// Additive number is a string whose digits can form additive sequence.

// A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

// For example:
// "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

// 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
// 1 + 99 = 100, 99 + 100 = 199
// Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

// Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

// Follow up:
// How would you handle overflow for very large input integers?

// Credits:
// Special thanks to @jeantimex for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question





// for this question, only need to determine the first num and second num
// O(n^2) time, O(1) space
public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i)  // i == the length of first integer
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)  // j == the length of second integer, n-i-j is the remaining length
                if (isValid(i, j, num)) return true;
        return false;
    }
    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false; // the first num start with 0
        if (num.charAt(i) == '0' && j > 1) return false; // the second num start with 0
        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start < num.length(); start += sum.length()) {
            x2 = x2 + x1; // x2 = x2 + x1
            x1 = x2 - x1; // x1 = old x2
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }
}