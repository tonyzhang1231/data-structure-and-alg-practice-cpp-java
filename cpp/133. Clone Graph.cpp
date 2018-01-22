/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
    
    unordered_map<int, UndirectedGraphNode*> map;
    
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(!node) return node;
        
        if (map.find(node->label)!=map.end()){
            return map[node->label];
        }
        
        UndirectedGraphNode* clone = new UndirectedGraphNode(node->label);
        map[clone->label] = clone;
        
        for (const auto& nb:node->neighbors ){
            clone->neighbors.push_back(cloneGraph(nb));
        }
        
        return clone;
        
    }
};