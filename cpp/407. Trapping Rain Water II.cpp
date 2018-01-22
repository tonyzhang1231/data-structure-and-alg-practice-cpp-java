#include "000LCHeader.h"

using namespace std;

class Solution {
private:
    struct Cell{
        int x, y, h;
        Cell(int xx, int yy, int hh):x(xx),y(yy),h(hh){}
    };
    
    struct compare{
        bool operator()(Cell* c1, Cell* c2){
            return c1->h > c2->h; // minheap => greater
        }  
    };
    
    int dirs[4][2] = {{1,0},{0,1},{-1,0},{0,-1}};
    
    bool isValid(const int& x, const int& y, const int* dir, const int& m, const int& n){
        int x1 = x+dir[0], y1 = y+dir[1];
        return x1>=0 && x1<m && y1>=0 && y1<n;
    }
    


public:
    int trapRainWater(vector<vector<int>>& A) {
        if (A.size()==0 || A[0].size()==0) return 0;
        int m = A.size(), n =A[0].size();
        int res = 0;
        priority_queue<Cell*, vector<Cell*>, compare> q;
        std::vector<std::vector<bool>> visit(m, std::vector<bool>(n,false));
        for (int i=0;i<m;i++){
            q.push(new Cell(i,0,A[i][0]));
            q.push(new Cell(i,n-1,A[i][n-1]));
            // q.emplace(i,0,A[i][0]);
            // q.emplace(i,n-1,A[i][n-1]);
            visit[i][0] = true;
            visit[i][n-1] = true;
        }
        for (int j=0;j<n;j++){
            q.push(new Cell(0,j,A[0][j]));
            q.push(new Cell(m-1,j,A[m-1][j]));
            // q.emplace(0,j,A[0][j]);
            // q.emplace(m-1,j,A[m-1][j]);
            visit[0][j] = true;
            visit[m-1][j] = true;
        }
        
        while(!q.empty()){
            Cell* cp = q.top();
            q.pop();
            int x = cp->x, y = cp->y, h = cp->h;
            for (auto& dir:dirs){
                if (isValid(x, y, dir,m,n) && !visit[x+dir[0]][y+dir[1]]){
                    if (A[x+dir[0]][y+dir[1]] < h){
                        res += h - A[x+dir[0]][y+dir[1]];
                        A[x+dir[0]][y+dir[1]] = h;
                    }
                    // q.emplace(x+dir[0], y+dir[1], A[x+dir[0]][y+dir[1]]);
                    q.push(new Cell(x+dir[0], y+dir[1], A[x+dir[0]][y+dir[1]]));
                    visit[x+dir[0]][y+dir[1]] = true;
                }
            }
        }
        return res;
    }
};

int main(){
    Solution obj;
    vector<vector<int>> A {
        {9,8,7,6},
        {5,1,2,6},
        {7,5,4,1}
    };

    cout << obj.trapRainWater(A) << '\n';
}

// g++ -std=c++14 407.\ Trapping\ Rain\ Water\ II.cpp -o out.o



// solution 2
// class Solution {
// public:
//     int trapRainWater(vector<vector<int>>& heightMap) {
//         if(heightMap.size()==0 || heightMap[0].size()==0) return 0;
        
//         //enque boundary cells & mark them as visited
//         int m=heightMap.size(), n=heightMap[0].size();
//         priority_queue<Cell> que;
//         vector<vector<bool>> visited(m, vector<bool>(n, false));
//         for(int i=0; i<m; i++) {
//             que.push(Cell(i,0,heightMap[i][0]));
//             que.push(Cell(i,n-1,heightMap[i][n-1]));
//             visited[i][0]=true;
//             visited[i][n-1]=true;
//         }
//         for(int j=0; j<n; j++) {
//             que.push(Cell(0,j,heightMap[0][j]));
//             que.push(Cell(m-1,j,heightMap[m-1][j]));
//             visited[0][j]=true;
//             visited[m-1][j]=true;
//         } 
        
//         // Going inward - using min_height node in queue & move in 4 directions & trap water locally
//         vector<int> xs({0,0,1,-1}), ys({1,-1,0,0}); // 4 directions
//         int water = 0;
//         while(!que.empty()) {
//             Cell cell = que.top();
//             que.pop();
//             for(int k=0; k<4; k++) {//move in 4 directions, if possible
//                 int xx=cell.x+xs[k], yy=cell.y+ys[k];
//                 if(xx<0 || xx>=m || yy<0 || yy>=n || visited[xx][yy]) continue;
//                 water+=max(cell.h-heightMap[xx][yy],0);
//                 que.push(Cell(xx,yy,max(cell.h,heightMap[xx][yy])));    
//                 visited[xx][yy]=true;
//             }
//         }
//         return water;
        
//     }
// private:
//     struct Cell {
//         int x, y, h;
//         Cell(int xx, int yy, int hh):x(xx), y(yy), h(hh) {}
//         bool operator<(const Cell& rhs) const {
//             return this->h > rhs.h;
//         }
//     };
// };