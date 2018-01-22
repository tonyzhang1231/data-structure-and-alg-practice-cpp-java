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
    TreeNode* sortedArrayToBST(vector<int>& A) {
        return helper(A, 0, A.size()-1);
    }
    
    TreeNode* helper(vector<int>& A, int start, int end){
        if (start > end) return nullptr;
        
        int mid = start + (end - start)/2;
        TreeNode* root = new TreeNode(A[mid]);
        root->left = helper(A, start, mid - 1);
        root->right = helper(A, mid + 1, end);
        return root;    
        
    }
};