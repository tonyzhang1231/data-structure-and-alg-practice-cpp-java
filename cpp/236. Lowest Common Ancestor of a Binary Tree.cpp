class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        return postOrder(root,p,q);

        
    }
    
    TreeNode* postOrder(TreeNode* root, TreeNode* p, TreeNode* q){
        if (root==nullptr || root==p || root == q) return root;
        
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        if (left!=nullptr && right!=nullptr) return root;
        if (left!=nullptr) return left;
        if (right!=nullptr) return right;
        return nullptr;
    }
    
};

