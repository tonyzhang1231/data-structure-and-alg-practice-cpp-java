// 259. 3Sum Smaller   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 19785
// Total Submissions: 48661
// Difficulty: Medium
// Contributors: Admin
// Given an array of n integers nums and a target, find the number of index triplets i, j, k 
// with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

// For example, given nums = [-2, 0, 1, 3], and target = 2.

// Return 2. Because there are two triplets which sums are less than 2:

// [-2, 0, 1]
// [-2, 0, 3]
// Follow up:
// Could you solve it in O(n2) runtime?

// Hide Company Tags Google
// Hide Tags Array Two Pointers
// Hide Similar Problems (M) 3Sum (M) 3Sum Closest



// if (sum<target) {
//     res += r - l; // very good, very good, very good, 
//     l++;
// }
public class Solution {
    public int threeSumSmaller(int[] A, int target) {
    	if (A==null || A.length<=2) return 0;

    	int res = 0;
        Arrays.sort(A);
        int n = A.length;
        for (int i=0;i<n-2;i++){
        	
        	int l = i+1, r = n-1;
        	while(l<r){
        		int sum = A[i] + A[l] + A[r];
        		if (sum<target) {
        			res += r - l; // very good, very good, very good, 
        			l++;
        		}
        		else{
        			r--;
        		}
        	}
        }
        return res;
    }
}


// target = 10
// 1 1 2 3 4 5 5  
// 