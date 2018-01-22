/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */


 // inorder traversal
class Solution {
public:
    int getMinimumDifference(TreeNode* root) {
        TreeNode* p = root;
        vector<TreeNode*> st;
        TreeNode* prev = nullptr; // must initialize it
        int res = INT_MAX;
        while (!st.empty() || p){
            while (p){
                st.push_back(p);
                p = p->left;
            }
            
            p = st.back();
            st.pop_back();
            
            if (prev) {
                res = std::min(res, p->val - prev->val);
            }
            prev = p;
            
            p = p->right;
            
        }
        return res;
    }
};