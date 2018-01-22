/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

 // without a global variable
class Solution {
public:
    int maxPathSum(TreeNode* root) {
        if (!root) return 0;
        vector<int> res = {INT_MIN, INT_MIN}; // max of left or right given a node, global max
        return dfs(root, res)[1];
    }
    
    // dfs, return [maxOneSide, maxTotal]
    vector<int> dfs(TreeNode* node, vector<int>& res){
        if (node==nullptr) return vector<int>(2,0);
        
        vector<int> left = dfs(node->left, res);
        vector<int> right = dfs(node->right, res);
        int l = max(left[0], 0);
        int r = max(right[0], 0);
        res[0] = max(l,r) + node->val;
        res[1] = max(res[1], node->val + l + r);
        return res;
    }
};

// with a global variable
class Solution {
public:
    int res = INT_MIN;
    
    int maxPathSum(TreeNode* root) {
        if (!root) return 0;
        dfs(root);
        return res;
    }
    
    // dfs, return [maxOneSide]
    int dfs(TreeNode* node){
        if (node==nullptr) return 0;
        
        int left = dfs(node->left);
        int right = dfs(node->right);
        int l = max(left, 0);
        int r = max(right, 0);
        res = max(res, node->val + l + r);
        return max(l,r) + node->val;
    }
};

