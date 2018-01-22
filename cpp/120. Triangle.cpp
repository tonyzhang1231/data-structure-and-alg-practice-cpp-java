class Solution {
public:
    int minimumTotal(vector<vector<int>>& A) {
        // pad a row of 0 in the end, then B[j] = min(B[j],B[j+1]) + A[i][j];
        vector<int> B(A.size() + 1,0);
        for (int i=A.size()-1;i>=0;i--){
            for (int j=0;j<A[i].size();j++){
                B[j] = min(B[j],B[j+1]) + A[i][j];
            }
        }
        return B[0];
    } 
};