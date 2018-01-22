power of four

public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n<=0 || (n&(n-1))!=0) return false;
        while(n>0){
            if ( (n&1) ==1 ) return true;
            n = n>>2;
        }
        return false;
    }
}

// 10000 = 16
// 1000 = 8