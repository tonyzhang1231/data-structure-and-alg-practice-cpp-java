class NumArray {
    
private:
    struct Node{
        int start;
        int end;
        int sum;
        Node* left;
        Node* right;
        Node(int s, int e): start(s), end(e), left(nullptr), right(nullptr), sum(0){};
        
    };
    
    // buildtree div and conq
    Node* buildtree(vector<int>& A, int start, int end){
        if (start>end) return nullptr;
        Node* root = new Node(start, end);
        if (start==end) 
            root->sum = A[start];
        else{
            int mid = start + (end - start)/2;
            root->left = buildtree(A, start, mid);
            root->right = buildtree(A, mid+1, end);
            root->sum = root->left->sum + root->right->sum;
        }
        return root;
    }
    
    //
    int getSum(Node* node, int i, int j){
        // no cover
        if (node==nullptr || i > node->end || j < node->start) return 0;
        // full cover
        if (i<= node->start && node->end<= j) return node->sum;
        // partial cover
        int left = getSum(node->left, i, j);
        int right = getSum(node->right, i, j); 
        return left + right;
    }
    
    void nodeUpdate(Node* node, int i, int diff){
        if (node==nullptr || i < node ->start || i> node ->end) return;
        node->sum += diff;
        nodeUpdate(node->left, i, diff);
        nodeUpdate(node->right, i, diff);
    }
    
public:
    vector<int> A;
    Node* root;
    
    NumArray(vector<int> nums) {
        A = nums; // or A = std::move(nums)   // copy or move both work
        root = buildtree(A, 0, A.size()-1);
    }
    
    void update(int i, int val) {
        int diff = val - A[i];
        A[i] = val;
        if (root)
            nodeUpdate(root, i, diff);
    }
    
    int sumRange(int i, int j) {
        return root==nullptr?0:getSum(root, i,j);    
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */