// 287. Find the Duplicate Number   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 50714
// Total Submissions: 121453
// Difficulty: Hard
// Contributors: Admin
// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

// Note:
// You must not modify the array (assume the array is read only).
// You must use only constant, O(1) extra space.
// Your runtime complexity should be less than O(n2).
// There is only one duplicate number in the array, but it could be repeated more than once.
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Hide Tags Binary Search Array Two Pointers
// Hide Similar Problems (H) First Missing Positive (E) Single Number (M) Linked List Cycle II (M) Missing Number

public class Solution {
    public int findDuplicate(int[] A) {
        int n = A.length;
        int lo = 1, hi = n-1;
        while(lo+1<hi){
            int mid = lo + (hi-lo)/2;
            int cnt=0;
            for (int a:A){
                if (a<=mid) cnt++; // if 1,2,...,mid are <=1, then cnt<=mid
            }
            if (cnt<=mid) {
                lo = mid;
            }else{
                hi = mid;
            }
        }
        int cnt = 0;
        for (int a:A){  
            if (a==lo) cnt++;
        }
        if (cnt>1) return lo;  // must be lo or hi
        return hi;
    }
    
    // 1 1 2  
}