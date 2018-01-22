// iterater row by row
// in each row, update left[j] and right[j], if 0, reset left[j] and right[j], update cur_left and cur_right
// if 1, left[j] should be dependent on cur_left and prev leftj, so is right
// update max 

class Solution {
public:
    int maximalRectangle(vector<vector<char>>& A) {
        if (A.size()==0) return 0;
        int m = A.size(), n = A[0].size();
        vector<int> h(n,0);
        vector<int> left(n,0), right(n,n);
        int res = 0;
        
        for (int i=0;i<m;i++){
            // update h
            int cur_left = 0;
            int cur_right = n;
            
            for (int j=0;j<n;j++){
                if (A[i][j]=='0') h[j] = 0;
                else h[j] += 1;
            }
            
            
            for (int j=0;j<n;j++){
                if (A[i][j]=='0'){
                    left[j]=0;
                    cur_left = j+1;
                }else{
                    left[j]=max(left[j], cur_left);
                }
            }
            
            
            for (int j=n-1;j>=0;j--){
                if (A[i][j]=='0'){
                    right[j] = n;
                    cur_right = j;
                }else{
                    right[j]=min(right[j], cur_right);
                }
            }
            
            for (int j=0;j<n;j++){
                res = max( res, (right[j]- left[j]) * h[j]);
            }
            
        }
        return res;
    }
};