class Solution {
public:
    int lengthOfLIS(vector<int>& A) {
        if (A.size()==0) return 0;
        int len = 1;
        for (int i=1;i<A.size();i++){
            int index = insertionBinarySearch(A, 0, len-1, A[i]);
            if (index == len) {
                len++;   
            }
            A[index] = A[i];
        }
        return len;
    }
    
    int insertionBinarySearch(vector<int>& A, int lo, int hi, int target){
        while (lo + 1 < hi){
            int mid = lo + (hi-lo)/2;
            if (A[mid] <= target) lo = mid;
            else hi = mid;
        }
        
        
        if (target<=A[lo]) return lo;
        if (target<=A[hi]) return hi;
        return hi + 1;
        
    }
    
    
};