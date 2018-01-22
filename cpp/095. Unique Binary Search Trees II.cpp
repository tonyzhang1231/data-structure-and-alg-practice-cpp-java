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

    unordered_map<int, vector<TreeNode*>> cache;

    vector<TreeNode*> generateTrees(int n) {
        if (n==0) return vector<TreeNode*>();
        return helper(n,1,n);
    }

    // d and c
    vector<TreeNode*> helper(int n, int start, int end){

        int key = (start - 1) * n + end - 1;
        if (cache.find(key)!= cache.end()) return cache[key];

        vector<TreeNode*> res; // initialize an empty vector

        if (start > end) {
            res.push_back(NULL); // or  nullptr https://stackoverflow.com/questions/20509734/null-vs-nullptr-why-was-it-replaced
            cache[key] = res;
            return res;
        }


        for (int i=start;i<=end;i++){

            vector<TreeNode*> left = helper(n, start, i-1);
            vector<TreeNode*> right = helper(n, i+1, end);

            for (auto& l:left){
                for (auto& r:right){
                    TreeNode* t = new TreeNode(i);
                    t->left = l;
                    t->right = r;
                    res.push_back(t);
                }
            }

        }

        cache[key] = res;
        return res;
    }

};
