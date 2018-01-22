#include "000LCHeader.h"

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


using namespace std;

class TreeUtil {
public:
    // Encodes a tree to a single string.
    static string serialize(TreeNode* root) {
        if (!root) return "#";
        return std::to_string(root->val)+" "+serialize(root->left)+" "+serialize(root->right);
    }

    // Decodes your encoded data to tree.
    static TreeNode* deserialize(string data) {
        stringstream ss(data);
        return helper(ss);
    }
    
    static TreeNode* helper(stringstream& ss){
        string node;
        std::getline(ss, node, ' ');
        if (node=="#") return nullptr;
        TreeNode* root = new TreeNode(std::stoi(node));
        root->left = helper(ss);
        root->right = helper(ss);
        return root;
    }
};

std::ostream& operator<<(std::ostream& os, TreeNode* t){
    os << TreeUtil::serialize(t);
    return os;
};

int main(){
    TreeNode* tree = TreeUtil::deserialize("1 2 3 # # # #");
    std::cout << tree->left << '\n';
    std::cout<< tree << '\n';
}


// std::to_string()
// http://en.cppreference.com/w/cpp/string/basic_string/to_string

// std::stoi()
// http://en.cppreference.com/w/cpp/string/basic_string/stol



// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));