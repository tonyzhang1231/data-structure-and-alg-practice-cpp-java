// Longest Substring Without Repeating Characters

// 3. Longest Substring Without Repeating Characters   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 232778
// Total Submissions: 983758
// Difficulty: Medium
// Contributors: Admin
// Given a string, find the length of the longest substring without repeating characters.

// Examples:

// Given "abcabcbb", the answer is "abc", which the length is 3.

// Given "bbbbb", the answer is "b", with the length of 1.

// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
// "pwke" is a subsequence and not a substring.

// Subscribe to see which companies asked this question

// Hide Tags Hash Table Two Pointers String
// Hide Similar Problems (H) Longest Substring with At Most Two Distinct Characters

// 3. Longest Substring Without Repeating Characters

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int start = -1;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                start = Math.max(start, map.get(c)); // must be max() here
            }
            map.put(c, i);
            max = Math.max(max,i - start);
        }
        return max;
    }
    
    // two pointers, j goes first, until repeating character is found, then i goes until the repeating is removed
    // 
    // pw w  kew
    //       i    j   
    
    // set ={p, w}
    // j = 2 
    // i =  
    // max = 2;
    
    // wawabaw
        // i  j
        // j
}
