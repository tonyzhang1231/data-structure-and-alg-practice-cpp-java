#include "000LCHeader.h"

using namespace std;

class Solution {
public:
    static vector<int> maxSlidingWindow(vector<int>& A, int k) {
        vector<int> res;
        deque<int> q;
        for (int i=0;i<A.size();i++){

        	while( !q.empty() && i - q.front() >= k){
                q.pop_front();
            } 
            
            while (!q.empty() && A[i] >= A[q.back()]) {
        		q.pop_back();
        	}
        	q.push_back(i);

        	if (i-k+1>=0)
        		res.push_back(A[q.front()]);
        }
        return res;
    }
};

int main(){
	vector<int> A {3,2,5,1,2,4,7,8};
	for (auto& x: Solution::maxSlidingWindow(A, 3) )
		cout << x << '\n';
	// 5 5 5 4 7 8
}

// deque