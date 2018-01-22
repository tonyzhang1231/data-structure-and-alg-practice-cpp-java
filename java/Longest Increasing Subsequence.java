// 300. Longest Increasing Subsequence


public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}


class Solution {
    public int lengthOfLIS(int[] A) {
        if (A==null || A.length==0) return 0;
        int len = 1;
        for (int i = 1;i< A.length;i++){
            int insertIndex = binarySearch(A, 0, len-1, A[i]);
            A[insertIndex] = A[i];
            if (insertIndex==len) len++;            
        }
        return len;
    }
    
    int binarySearch(int[] A, int lo, int hi, int target){
        while(lo + 1 <hi){
            int mid = lo + (hi - lo)/2;
            if (A[mid] < target){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        
        if (A[hi] < target) return hi + 1;
        if (A[lo] < target) return hi;
        return lo;
    }
}