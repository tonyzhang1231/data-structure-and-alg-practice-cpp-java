class Solution {
public:
    int mySqrt(int x) {
        long lo = 0, hi = x;
        while(lo + 1 < hi){
            long mid = lo + (hi - lo)/2;
            if (mid * mid == x) return (int) mid;
            if (mid * mid < x){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        
        if (hi * hi == x) return (int ) hi;
        return  (int) lo;
    }
};