// 153. Find Minimum in Rotated Sorted Array   Add to List QuestionEditorial Solution  My Submissions

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// You may assume no duplicate exists in the array.



public class Solution {
    public int findMin(int[] A) {
        int n = A.length;
        int lo = 0, hi = n-1;  
        while(lo+1<hi){
        	if (A[lo]<A[hi]) return A[lo];  // this is important

        	int mid = lo + (hi - lo)/2;
        	if (A[lo]<A[mid]){
        		lo = mid;
        	}else{
        		hi = mid;
        	}
        }
        if (A[lo]<A[hi]) return A[lo];
        return A[hi];
    }
}



// Find Minimum in Rotated Sorted Array II

// duplicates are allowed
public class Solution {
    public int findMin(int[] A) {
        int n = A.length;
        int lo = 0, hi = n-1;  
        while(lo+1<hi){
        	if (A[lo]<A[hi]) return A[lo];  // this is important

        	int mid = lo + (hi - lo)/2;
        	if (A[lo]==A[mid] && A[mid]==A[hi]){
        		lo++;hi--;  // this one is good
        	}else if(A[lo]==A[mid] && A[mid]!=A[hi]){
        		lo = mid;
        	}else if(A[mid]==A[hi] && A[lo]!=A[mid]){
        		hi = mid;
        	}else if(A[lo]<A[mid]){
        		lo = mid;
        	}else{
        		hi = mid;
        	}
        }
        if (A[lo]<A[hi]) return A[lo];
        return A[hi];
    }
}


// 3 3 3 3 3 1 2 3 3
// l       m       h

// 3 3 1 2 3 3 3 3 3


