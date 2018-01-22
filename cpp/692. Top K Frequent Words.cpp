class Solution {
public:
    
    struct compare{
        bool operator()(pair<string,int>& a, pair<string,int> &b ){
            if (a.second==b.second){
                return a.first.compare(b.first) < 0; // string should be maxheap, pop max
            }
            return a.second > b.second; // greater -> minheap
        }    
    };
    
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> map;
        for (string& w:words){
            if (map.count(w)==0) map[w]=0;
            map[w]++;
        }
        
        priority_queue<pair<string, int>, vector<pair<string,int>>, compare>  q;
        for (auto& p:map){
            q.push(p);
            if (q.size()>k) q.pop();
        }
        
        vector<string> res;
        while(!q.empty()){
            res.push_back(q.top().first);
            q.pop();
        }
        std::reverse(res.begin(),res.end());

        return res;
    }
};


// what if the input is a stream, and very large