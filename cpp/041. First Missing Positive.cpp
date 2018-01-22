class Solution {
public:
    int firstMissingPositive(vector<int>& A) {
        
        for (int i=0;i<A.size();i++){
            // A[i] = i+1, good
            while( A[i]!=i+1 && A[i]-1>=0 && A[i]-1<A.size() && A[A[i]-1]!=A[i]){
                // swap A[i] and A[A[i]-1]
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }
        
        for (int i=0;i<A.size();i++)
            if (A[i]!=i+1)
                return i+1;
        
        return A.size()+1;
        
    }
};