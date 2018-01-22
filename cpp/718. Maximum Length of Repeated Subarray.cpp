#include "000LCHeader.h"

using namespace std;

class Solution {
public:
    static int findLength(vector<int>& A, vector<int>& B) {
        int m = A.size(), n = B.size();
        vector<vector<int>> dp(m+1, vector<int>(n+1,0));

        // dp[i][j] represents longest sub array, ended with A[i-1] and B[j-1]
        // if A[i]!=B[j] then dp = 0
        // else dp = dp[i-1][j-1] + 1
        // every time update the max

        int max = 0;
        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (A[i-1]==B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = std::max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
};


int main(){
    vector<int> A {1,2,3,2,1};
    vector<int> B {3,2,1,4,5};
    cout << Solution::findLength(A,B) << endl;
    // 3
}


// g++ -std=c++14 718.\ Maximum\ Length\ of\ Repeated\ Subarray.cpp -o out.o
// ./out.o