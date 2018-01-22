#include "000LCHeader.h"

using namespace std;

class Solution {
public:
    static vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> res;
        unordered_set<string> set(wordList.begin(), wordList.end());
        if (set.find(endWord)==set.end()) return res;
        
        vector<string> path;
        path.push_back(beginWord);
        
        queue<vector<string>> q_path;
        q_path.push(move(path));
        bool pathFound = false;
        
        
        while (!q_path.empty()){
            int sz = q_path.size();
            // cout << sz << " = sz\n";
            unordered_set<string> tmp;
            while(sz-- >0){
                vector<string> path = q_path.front(); // get the first-in element
                string word = path.back();
                // cout << word << endl;
                q_path.pop();
                
                if (word==endWord){
                    res.push_back(move(path));
                    pathFound = true;
                }
                
                // if we found a path, we don't need go for longer path
                if (!pathFound){
                    for (int i=0;i<word.size();i++){
                        char c = word[i];
                        for (char ch = 'a';ch<='z';ch++){
                            if (ch == c) continue;
                            word[i] = ch;
                            if (set.find(word)!=set.end()) {
                                vector<string> newpath = path; // need to copy a path
                                newpath.push_back(word);
                                // for (auto& e:newpath){
                                //     cout << e << " ";
                                // }
                                // cout << '\n';
                                q_path.push(move(newpath));
                                tmp.insert(word);
                            }
                        }
                        word[i] = c;
                    }
                }  // if
            }// while
            for (auto& word: tmp){
                set.erase(word);
            }
            // for (auto& word: set){
            //     cout << word + " ";
            // }
            // cout << "settt\n";
        }
        return res;
        
    }
};


int main(){
    string beginWord {"hit"}, endWord {"cog"};
    vector<string> wordList {"hot","dot","dog","lot","log","cog"};
    for (auto e:Solution::findLadders(beginWord, endWord, wordList)){
        for (string& s:e)
            cout << s << " ";
        cout << "\n";
    }
}

// [
//    ["hit","hot","dot","dog","cog"],
//    ["hit","hot","lot","log","cog"]
// ]


// g++ -std=c++14