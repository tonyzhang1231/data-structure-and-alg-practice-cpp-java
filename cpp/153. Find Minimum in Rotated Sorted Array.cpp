class Solution {
public:
    int findMin(vector<int>& A) {

        int lo = 0, hi = A.size()-1;
        while (lo + 1 < hi){
            if (A[lo] < A[hi]) return A[lo];

            int mid = lo + (hi-lo)/2;
            if (A[mid] > A[lo]) {
                lo = mid;
            }else{
                hi = mid;
            }

        }
        if (A[lo] < A[hi]) return A[lo];
        return A[hi];

    }
};
