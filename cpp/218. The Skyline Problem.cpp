class Solution {
public:
    vector<pair<int, int>> getSkyline(vector<vector<int>>& buildings) {
        vector<pair<int, int>> res;
        vector<pair<int,int>> lines;
        for (auto& b:buildings){
            lines.push_back(make_pair(b[0],-b[2])); // l + (-h)
            lines.push_back(make_pair(b[1],b[2])); // l + h
        }
        
        std::sort(lines.begin(),lines.end(), [](pair<int,int>& a, pair<int,int>& b){
            if (a.first == b.first) return a.second < b.second;
            return a.first < b.first;
        });
        
        multiset<int> q;
        q.insert(0);
        int pre_max = 0;
        for (auto& p:lines){
            if (p.second<0){
                q.insert(-p.second);
            }else{
                q.erase(q.find(p.second));
            }
            int cur_max = *(q.rbegin());
            if (cur_max != pre_max){
                res.push_back(make_pair(p.first, cur_max));
                pre_max = cur_max;
            }
        }
        return res;
        
    }
};