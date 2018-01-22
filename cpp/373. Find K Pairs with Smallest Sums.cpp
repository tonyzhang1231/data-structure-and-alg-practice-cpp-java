class Solution {



public:
    struct Node{
        int x;
        int y;
        int sum;
        Node(int _x, int _y, int _sum): x(_x), y(_y), sum(_sum) {};
    };

    struct compare{
        bool operator() (Node* n1, Node* n2){
            return n1->sum > n2->sum;   // greater means min heap, less means max heap
        }
    };

    vector<pair<int, int>> kSmallestPairs(vector<int>& A, vector<int>& B, int k) {
        vector<pair<int, int>> res;
        if (k==0 || A.size()==0 || B.size()==0) return res;

        priority_queue<Node*, vector<Node*>, compare> q;
        for (int i=0;i<A.size();i++){
            Node* node_ptr = new Node(i,0, A[i] + B[0]);
            q.push(node_ptr);
        }


        while (!q.empty() && k>0){
            Node* tmp = q.top();
            q.pop();
            res.push_back(make_pair(A[tmp->x],B[tmp->y]));
            if (tmp->y < B.size() - 1){
                Node* node_ptr = new Node(tmp->x, tmp->y + 1, A[tmp->x]+B[tmp->y + 1]);
                q.push(node_ptr);
            }
            k--;
        }
        return res;

    }
};



// use vector<int> instead of Node*
class Solution {
public:
    
    struct compare{
        bool operator()(const vector<int>& A, const vector<int>& B ){
            return A[2] > B[2];
        }
    };
    
    vector<pair<int, int>> kSmallestPairs(vector<int>& A, vector<int>& B, int k) {
        
        vector<pair<int, int>> res;
        if (A.size()==0 || B.size()==0 || k<=0) return res;
        priority_queue<vector<int>, vector<vector<int>>, compare> pq;
        for (int y=0;y<B.size();y++){
            vector<int> tmp {0,y,A[0]+B[y]};
            pq.push(std::move(tmp));
        }
        
        while (!pq.empty() and k>0){
            auto tmp = pq.top();
            pq.pop();
            k--;
            int x = tmp[0], y = tmp[1];
            res.push_back(make_pair(A[x],B[y]));
            if (x<A.size()-1) pq.push({x+1,y, A[x+1]+B[y]});
        }
        
        return res;
        
        
    }
};

