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
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode*> st;
        while (root || !st.empty()){
            while(root){
                st.push(root);
                root = root->left;
            }
            
            root = st.top();
            st.pop();
            
            k--;
            if (k==0) break;
            
            root=root->right;
        }
        return root?root->val:0;
    }
};