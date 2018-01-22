// 162. Find Peak Element   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 95504
// Total Submissions: 266697
// Difficulty: Medium
// Contributors: Admin
// A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that num[-1] = num[n] = -∞.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

public class Solution {
    public int findPeakElement(int[] A) {
        int lo = 0, hi = A.length-1;
        while(lo+1<hi){
        	int mid = lo + (hi-lo)/2;
        	if (A[mid-1]<A[mid] && A[mid]<A[mid+1]){
        		lo = mid;
        	}else {
        		hi = mid; 
        	}
        }
        if (A[lo]>A[hi]) return lo;
        return hi;
    }
}