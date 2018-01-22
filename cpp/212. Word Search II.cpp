#include "000LCHeader.h"

using namespace std;

class Solution {
private:
    struct Node{
        string word = "";
        Node* next[26];
        Node(){
            std::memset(next, 0, sizeof(next));
        }
    };
    
    // must know how to build a trie
    Node* buildTrie(vector<string>& words){
        Node* root = new Node();
        for (auto& w:words){
            Node* node = root; // temp node
            for (int i=0;i<w.size();i++){
                char c = w[i];
                if (node->next[c-'a']==nullptr) node->next[c-'a'] = new Node();
                node = node->next[c-'a'];
            }
            node->word = w;
        }
        return root;
    }
    
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        vector<string> res;
        Node* root = buildTrie(words);
        // for (int i=0;i<26;i++){
        //     if (root->next[i]==nullptr) cout << i;
        // }
        int m = board.size(), n = board[0].size();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                dfs(board, res, root, i, j, m, n);
            }
        }
        return res;
    }
    
    const int dirs[4][2] = {{1,0},{-1,0},{0,1},{0,-1}};
    
    void dfs(vector<vector<char>>& board, vector<string>& res, Node* root, int i, int j, const int& m, const int& n){
        if (i<0 || i>=m || j<0 || j>=n || board[i][j]=='#') return;
        
        char c = board[i][j];
        if (root->next[c-'a']==nullptr) return;
        root = root->next[c-'a'];
        // cout << root->word << endl;
        if (root->word.size()>0){
            res.push_back(move(root->word));
            //root->word = "";
        }
        
        board[i][j] = '#';
        for (auto& dir: dirs){
            dfs(board, res, root, i+ dir[0], j+dir[1],m,n);
        }
        board[i][j] = c;   
    }
};


int main(){
    Solution obj;
    std::vector<std::vector<char>> board {
        {'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}
    };

    std::vector<string> words {"oath","pea","eat","rain"};
    auto res = obj.findWords(board, words);

    for (auto& s:res){
        std::cout << s << endl;
    }
}

// g++ -std=c++14 212.\ Word\ Search\ II.cpp -o out.o
