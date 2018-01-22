class Solution {
public:
    int maxSubArray(vector<int>& A) {
        if (A.size()==0) return 0;
        int res = A[0];
        int sum = A[0];
        for (int i=1;i<A.size();i++){
            if (sum < 0) sum = 0;
            sum+= A[i];
            res = max(res, sum);
        }
        return res;
    }
};

