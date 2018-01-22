class Solution {
public:
    int trap(vector<int>& A) {
        int lmax = 0, rmax = 0;
        int l= 0, r = A.size()-1;
        int res = 0;
        while (l<r){
            lmax = max(A[l], lmax); // update lmax and rmax every time
            rmax = max(A[r], rmax);
            if (lmax < rmax){
                res += (lmax - A[l]);
                l++;
            }else{
                res += rmax - A[r];
                r--;
            }
        }
        return res;
    }
};