class Solution {
public:
    int removeDuplicates(vector<int>& A) {
        if (A.size()<=2) return A.size();
        int i = 0, j = 0;
        while (j<A.size()){
            if (i<2 || A[j]!=A[i-2]){
                A[i++] = A[j];
            }
            j++;
        }
        return i;
        
    }
};