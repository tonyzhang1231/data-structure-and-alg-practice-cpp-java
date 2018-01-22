class Solution {
public:
    int search(vector<int>& A, int target) {
        if (A.size()==0) return -1;
        int lo = 0, hi = A.size()-1;
        while (lo + 1 < hi){

            int mid = lo + (hi - lo)/2;
            if (A[mid]==target) return mid;

            if (A[lo] < A[mid]){  // left is ascending
                if (target < A[mid] && target >= A[lo]) hi = mid;  // if mid < target, go to left side
                else lo = mid;  // else go to right side
            }else{  // right is ascending
                if (target > A[mid] && target <= A[hi]) lo = mid;
                else hi = mid;
            }

        }

        if (A[lo] == target) return lo;
        if (A[hi] == target) return hi;
        return -1;
    }
};
