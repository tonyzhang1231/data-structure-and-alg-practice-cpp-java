class Solution {
public:
    int climbStairs(int n) {
        // fn = fn-2 + fn-1
        // f0 = 1; f1 = 1
        // f2 = 2
        // f3 = 3
        int p1 = 1, p2 = 1;
        for (int i=2;i<=n;i++){
            p1 = p1 + p2;
            p2 = p1 - p2;
        }
        return p1;
    }
};