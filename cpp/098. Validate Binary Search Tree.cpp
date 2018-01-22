/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        
        TreeNode* p = root;
        TreeNode* prev = nullptr;
        stack<TreeNode* > st;
        while (p || !st.empty()){
            while(p){
                st.push(p);
                p = p->left;
            }
            
            p = st.top();
            st.pop();
            
            if (prev && prev->val >= p->val) return false;
            prev = p;
            
            p = p->right;
            
            
        }
        return true;
    }
};