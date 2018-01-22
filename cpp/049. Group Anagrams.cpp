class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        if (strs.size()==0) return res;
        
        unordered_map<string, vector<string>> map;
        for (auto& s: strs){
            auto key = s;
            std::sort(key.begin(),key.end());
            // if (map.find(key)==map.end()) 
                // map[key] = vector<string>();
            map[key].push_back(s);
            
        }
        
        for (auto& e:map){
            res.push_back(e.second); // e is a pair
        }
        return res;
    }
};