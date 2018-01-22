// 179. Largest Number   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 63603
// Total Submissions: 297353
// Difficulty: Medium
// Contributors: Admin
// Given a list of non negative integers, arrange them such that they form the largest number.

// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

// Note: The result may be very large, so you need to return a string instead of an integer.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Sort



public class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            strs[i] = nums[i] + "";
        }
        
        Arrays.sort(strs, (s1,s2)-> (s2+s1).compareTo(s1+s2) );
        
        if (strs[0].charAt(0) == '0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s:strs){
        	sb.append(s);
        }
        return sb.toString();
    }
}



// need a comparator (int a,int b) -> (  )
[3, 30, 34, 5, 9]




