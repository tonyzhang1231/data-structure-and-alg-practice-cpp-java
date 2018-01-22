
// use unique pointer, very slow

struct Node{    
    bool isWord = false;
    std::vector<std::unique_ptr<Node>> next(26, std::unique_ptr<Node>);
    // Node(){
    //     for (int i=0;i<26;i++) next.push_back(std::unique_ptr<Node>{});
    // }
};

class Trie {
public:
    /** Initialize your data structure here. */


    std::unique_ptr<Node> root;
    
    Trie():root(std::make_unique<Node>()) {
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Node* node = root.get();
        for (char c:word){
            if (!node->next[c-'a']){
                node->next[c-'a'] = std::make_unique<Node>();
            }
            node = node->next[c-'a'].get();
        }
        node->isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Node* node = root.get();
        for (char c:word){
            if (!node->next[c-'a']){
                return false;
            }
            node = node->next[c-'a'].get();
        }
        return node->isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string word) {
        Node* node = root.get();
        for (char c:word){
            if (!node->next[c-'a']){
                return false;
            }
            node = node->next[c-'a'].get();
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * bool param_2 = obj.search(word);
 * bool param_3 = obj.startsWith(prefix);
 */







/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * bool param_2 = obj.search(word);
 * bool param_3 = obj.startsWith(prefix);
 */

// 68 ms, a little faster
struct Node{
    bool isWord = false;
    // Node* next[26] {0}; // all are nullptr
    Node* next[26];
    Node(){
        memset(next, 0, sizeof(next));
    }
    ~Node(){
        for (auto p : next)
            delete p;
    }
};

class Trie {
public:
    /** Initialize your data structure here. */
    Node* root;
    
    Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Node* node = root;
        for (char c:word){
            if (!node->next[c-'a']){
                node->next[c-'a'] = new Node();
            }
            node = node->next[c-'a'];
        }
        node->isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Node* node = root;
        for (char c:word){
            if (!node->next[c-'a']){
                return false;
            }
            node = node->next[c-'a'];
        }
        return node->isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string word) {
        Node* node = root;
        for (char c:word){
            if (!node->next[c-'a']){
                return false;
            }
            node = node->next[c-'a'];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * bool param_2 = obj.search(word);
 * bool param_3 = obj.startsWith(prefix);
 */


 struct Node{    
    bool isWord = false;
    std::vector<std::unique_ptr<Node>> next;
    Node(){
        for (int i=0;i<26;i++) next.push_back(std::unique_ptr<Node>());
    }
};

class Trie {
public:
    /** Initialize your data structure here. */
    std::unique_ptr<Node> root;
    
    Trie():root(new Node) {
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Node* node = root.get();
        for (char c:word){
            if (!node->next[c-'a']){
                node->next[c-'a'].reset(new Node);
            }
            node = node->next[c-'a'].get();
        }
        node->isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Node* node = root.get();
        for (char c:word){
            if (!node->next[c-'a']){
                return false;
            }
            node = node->next[c-'a'].get();
        }
        return node->isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string word) {
        Node* node = root.get();
        for (char c:word){
            if (!node->next[c-'a']){
                return false;
            }
            node = node->next[c-'a'].get();
        }
        return true;
    }
};
