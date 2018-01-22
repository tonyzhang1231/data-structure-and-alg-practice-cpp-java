class Solution {
public:
    int divide(int dividend, int divisor) {
        if(divisor == 0||(dividend == INT_MIN && divisor == -1))
            return INT_MAX;


        long dd = (long) dividend;
        long ds = (long) divisor;
        bool isPos = dd * ds > 0;
        dd = abs(dd);
        ds = abs(ds);

        int res = 0;
        while (dd >= ds){

            int shift = 1;
            while (dd >= (ds<< shift) ){
                shift++;
            }
            res += (1<< (shift-1));
            dd -= (ds<< (shift-1));

        }
        return isPos?res:-res;
    }
};
