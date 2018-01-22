class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> wordset(wordList.begin(), wordList.end());
        if (wordset.find(endWord)==wordset.end()) return 0; // if endWord is not in the set
        
        
        wordset.insert(endWord);
        
        queue<std::string> q;
        queue<int> q_dist;
        q.push(beginWord);
        q_dist.push(1);
                
        while(!q.empty()){
            string word = q.front();
            q.pop();
            int dist = q_dist.front();
            q_dist.pop();
            if (word==endWord){
                return dist;
            }
            for (int i=0;i<word.size();i++){
                char temp_char = word[i];
                for (char c='a';c<='z';c++){
                    if (c==temp_char) continue;
                    word[i] = c;
                    if (wordset.find(word)!=wordset.end()){
                        q.push(word);
                        q_dist.push(dist+1);
                        wordset.erase(word);
                    }
                }
                word[i] = temp_char;
            }
            
        }
        return 0;
    }
};


// queue
// front, pop, push
// set
// insert, erase, find
