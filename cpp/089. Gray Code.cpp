class Solution {
public:
    vector<int> grayCode(int n) {

        // The idea is simple. G(i) = i^ (i/2).
        
        vector<int> res;
        for (int i=0;i< 1<<n;i++){
            res.push_back(i^(i>>1));
        }
        return res;
    }
};