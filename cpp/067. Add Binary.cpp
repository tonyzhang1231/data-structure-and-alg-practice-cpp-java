class Solution {
public:
    string addBinary(string a, string b) {
        int i = a.size()-1, j = b.size()-1;
        int carry = 0;
        string res = "";
        while (i>=0 || j>=0){
            int n1 = i>=0?(a[i] - '0'):0;
            int n2 = j>=0?(b[j] - '0'):0;
            int sum = n1+n2+carry;
            carry = sum/2;
            sum = sum%2;
            res = (char)(sum + '0') + res;
            i--;
            j--;
        }
        if (carry == 1) res = '1' + res;
        return res;
    }
};