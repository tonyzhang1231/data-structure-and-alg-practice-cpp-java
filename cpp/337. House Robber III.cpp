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
    int rob(TreeNode* root) {
        // the current max = max(rob the current node && not rob two child node, not rob the current node, max of two child node)
        // bottom up, return up 3 integers, rob, notrob and max
        return dfs(root)[2];
    }

    vector<int> dfs(TreeNode* node){
        if (node==nullptr) return vector<int>(3);

        vector<int> left = dfs(node->left);
        vector<int> right = dfs(node->right);
        int rob_val = node->val + left[1] + right[1];
        int notrob_val = left[2] + right[2];
        int cur_max = max(rob_val, notrob_val);
        return {rob_val, notrob_val, cur_max};
    }
};
