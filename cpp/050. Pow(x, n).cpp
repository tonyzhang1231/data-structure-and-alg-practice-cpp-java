class Solution {
public:
    double myPow(double x, int n) {
        if (n==INT_MIN)
            return myPow(1/x, INT_MAX)/x;
        
        if (n<0) return myPow(1/x, -n);
        
        if (n==0) return 1;
        if (n==1) return x;
        double half = myPow(x, n/2);
        return n%2==0?half*half:half*half*x;
    }
};