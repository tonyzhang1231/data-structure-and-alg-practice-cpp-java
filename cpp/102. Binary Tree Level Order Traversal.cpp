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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        dfs(root, res, 0);
        return res;
    }

    void dfs(TreeNode* root, vector<vector<int>>& res, int level){
        if (root==nullptr) return;
        if (level==res.size()){
            res.push_back(vector<int>());
        }
        res[level].push_back(root->val);

        dfs(root->left, res, level+1);
        dfs(root->right, res, level+1);
    }
};
