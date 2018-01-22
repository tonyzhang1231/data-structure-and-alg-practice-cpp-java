// 344. Reverse String   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 120677
// Total Submissions: 209610
// Difficulty: Easy
// Contributors: Admin
// Write a function that takes a string as input and returns the string reversed.

// Example:
// Given s = "hello", return "olleh".


public class Solution {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}