class Solution {
public:
    bool canFinish(int n, vector<pair<int, int>>& prerequisites) {
        vector<vector<int>> graph(n); //pre -> course
        vector<int> degree(n,0);
        for (auto& p:prerequisites){   //pair course,pre
            graph[p.second].push_back(p.first);
            degree[p.first]++;
        }
        
        queue<int> q;
        
        for (int i=0;i<n;i++){
            if (degree[i]==0) {
                q.push(i);
            }
        }
        
        int count = q.size();
        while(!q.empty()){
            int finished = q.front();
            q.pop();
            for (auto& course:graph[finished]){
                degree[course]--;
                if (degree[course]==0) {
                    q.push(course);
                    count++;
                }
            }
        }
        
        return count == n;
    }
};