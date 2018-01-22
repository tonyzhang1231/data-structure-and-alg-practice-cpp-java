#include "000LCHeader.h"

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& A) {
        vector<vector<int>> res;
        if (A.size() <=2 ) return res;

        sort(A.begin(),A.end()); // std::sort
        for (int i=0;i<A.size()-2;i++){
            if (i>0 && A[i] == A[i-1] ) continue;
            if (A[i] + A[i+1] + A[i+2]>0) break;
            if (A[i] + A[A.size()-2] + A[A.size()-1]<0) continue;

            int j = i+1, k = A.size()-1;
            while (j<k){
                int sum = A[i] + A[j] +A[k];
                if (sum==0) {
                    res.push_back({A[i],A[j],A[k]});
                    j++;k--;
                    while(j<k && A[j]==A[j-1]) j++;
                    while(j<k && A[k]==A[k+1]) k--;

                }else if(sum>0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return res;
    }
};
