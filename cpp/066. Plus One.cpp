class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        
        int sz = digits.size();
        for (int i=sz - 1; i>=0;i--){
            if (digits[i]<9){
                digits[i]++;
                return digits;
            } 
            else{
                digits[i] = 0;
            }
        }
        digits.insert(digits.begin(),1);
        return digits;
    }
};