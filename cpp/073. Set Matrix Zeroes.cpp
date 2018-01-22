class Solution {
public:
    void setZeroes(vector<vector<int>>& A) {
        
        bool fr = false, fc = false;
        int m = A.size(), n = A[0].size();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (A[i][j]==0){
                    if (i==0) fr = true;
                    if (j==0) fc = true;
                    A[i][0] = 0; 
                    A[0][j] =0;
                    
                }
            }
        }
        
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (A[i][0]==0 || A[0][j] == 0) A[i][j] = 0;
            }
        }
        
        if (fr){
            for (int j=0;j<n;j++) A[0][j] = 0;
        }
        
        if (fc){
            for (int i=0;i<m;i++) A[i][0] = 0;
        }
    }
};