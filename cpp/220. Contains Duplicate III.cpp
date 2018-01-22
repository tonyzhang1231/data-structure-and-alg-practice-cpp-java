class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& A, int k, int t) {
        if (t<0 || k<=0) return false;
        
        unordered_map<long, long> map;
        for (int i=0;i<A.size();i++){
            long b = A[i] ;
            b -= INT_MIN;
            long bucket = b/ ( (long) t +1);
            if (i-k>0) map.erase( (((long) A[i-k-1]) - INT_MIN)/  ((long) t +1) );
            if (map.find(bucket)!=map.end()) return true;
            if (map.find(bucket-1)!=map.end() && b - map[bucket-1] <=t ) return true;
            if (map.find(bucket+1)!=map.end() && map[bucket+1] - b <=t ) return true;
            map[bucket] = b;
        }
        return false;
    }
};