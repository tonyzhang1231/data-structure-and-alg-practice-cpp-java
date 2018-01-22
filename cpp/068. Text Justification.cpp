class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int L) {
        
        vector<string> res;
        int index = 0;
        int n = words.size();
        
        while (index < n ){
            string cur = words[index];
            int last = index + 1;
            int len = cur.size();
            while (last < n && len + 1 + words[last].size() <=L){
                len += 1 + words[last].size();
                last++;
            }
            // last is not inclusive, 
            
            int numOfWords = last - index;
            string line = "";
            // process
            if (numOfWords==1){
                line += words[index];
                line += std::string(L-len, ' ');
            }else if(last == n){
                for (int i=index;i<n-1;i++){
                    line += words[i] + " ";
                }
                line += words[n-1];
                line += std::string(L-len, ' ');
            }else{
                // remaining space = L - len, number of slots = numOfWords - 1
                int numSpace = (L-len)/(numOfWords-1) + 1;
                int extra = (L-len)%(numOfWords-1);
                for (int i=index;i<last-1;i++){
                    line += words[i] + std::string(numSpace, ' ');
                    if (i - index < extra) line += " ";
                }
                line += words[last-1];
            }
            
            //
            res.push_back(std::move(line));
            index = last;
        }
        return res;
    }
};