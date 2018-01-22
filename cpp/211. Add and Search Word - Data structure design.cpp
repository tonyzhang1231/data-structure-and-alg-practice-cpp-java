#include "000LCHeader.h"

using namespace std;

struct Node{
	string word ="";
	Node* next[26];
	Node(){
		std::memset(next, 0, sizeof(next));
	}
};

class WordDictionary {
private:
	Node* root;


public:
    /** Initialize your data structure here. */
    WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    void addWord(string word) {
        Node* node = root;
        for (int i=0;i<word.size();i++){
        	char c = word[i];
        	if (node->next[c-'a']==nullptr) node->next[c-'a'] = new Node();
        	node = node->next[c-'a'];
        }
        node->word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    bool search(string word) {
        return helper(word, 0, root);
    }

    bool helper(string& word, int i, Node* node){
    	if (i==word.size()) return node->word!="";
    	char c = word[i];
    	if (c!='.' and node->next[c-'a']==nullptr)
    		return false;
    	else if(c!='.' and node->next[c-'a']!=nullptr)
    	{
    		return helper(word, i+1, node->next[c-'a']);
    	}else{
    		for (int j=0;j<26;j++){
    			if (node->next[j]!=nullptr and helper(word,i+1,node->next[j])) return true;
    		}
    	}
    	return false;
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * bool param_2 = obj.search(word);
 */

int main(){
	WordDictionary obj;
	obj.addWord("good");
	obj.addWord("boy");
	cout << boolalpha;
	cout << obj.search("goo") << endl;
	cout << obj.search("good")<< endl;
	cout << obj.search("b.y")<< endl;
	cout << obj.search("...")<< endl;
}

// g++ -std=c++14 211.\ Add\ and\ Search\ Word\ -\ Data\ structure\ design.cpp -o out.o
