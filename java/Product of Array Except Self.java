// 238. Product of Array Except Self   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 77529
// Total Submissions: 165011
// Difficulty: Medium
// Contributors: Admin
// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

// Follow up:
// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

// Subscribe to see which companies asked this question



public class Solution {
    public int[] productExceptSelf(int[] A) {
        int[] res = new int[A.length];
        Arrays.fill(res,1);
        
        for (int i=1;i<A.length;i++){
            res[i] = res[i-1]* A[i-1];
        }
        
        for (int i=A.length-2;i>=0;i--){
            res[i] *= A[i+1];
            A[i] *= A[i+1];
        }
        return res;
    }
}

// O(n) time and O(n) space
// A = 1 2 3 4 5

// res = 1  1  1  1  1
// after one pass
// a1 a2   a3   a4*a5         a5          A[i] = A[i] * A[i+1]
// 1  a1  a1*a2  a1*a2*a3   a1*a2*a3*a4    res[i] = res[i]*A[i+1]
// after one reverse pass
//                 a1*a2*a3*a5         a1*a2*a3*a4



