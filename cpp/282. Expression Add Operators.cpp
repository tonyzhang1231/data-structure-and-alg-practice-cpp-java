class Solution {
public:
    vector<string> addOperators(string num, int target) {
        vector<string> res;
        string tmp = "";
        dfs(num, target, res, tmp, 0, 0, 0);
        return res;
    }
    
    void dfs(string& num, int target, vector<string>& res, string tmp, int start, long val, long prev){
        if (start==num.size()){
            if (val == target){
                res.push_back(tmp);
            }
            return;
        }
        
        for (int i=start;i<num.size();i++){
            if (i>start && num[start]=='0') break;
            long cur = std::stol(num.substr(start,i - start + 1));
            
            // int len = tmp.size();
            if (start==0){
                dfs(num, target, res, to_string(cur), i+1, cur , cur);
            }else{
                dfs(num, target, res, tmp + "+" + to_string(cur), i+1, val + cur , cur );
                dfs(num, target, res, tmp + "-" + to_string(cur), i+1, val - cur , -cur );
                dfs(num, target, res, tmp + "*" + to_string(cur), i+1, val - prev + prev * cur , prev * cur );
            }
            
            
        }
    }
};  

