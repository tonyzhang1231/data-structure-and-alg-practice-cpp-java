class Solution {
public:
    bool canJump(vector<int>& A) {
        // if A[i] + i >=n-1, true
        
        int furthest = 0;
        int index = 0;
        while (index <= furthest){
            if (A[index] + index >= A.size()-1) return true;
            furthest = max(furthest, A[index] + index);
            index++;
        }
        return false;
        
    }
};


