// O(N^2) space, can be reduced to O(n) space

class Solution {
public:
int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {

    int row=obstacleGrid.size();
    int col=obstacleGrid[0].size();
    vector<vector<int>> k(row,vector<int>(col,0));


    if(obstacleGrid[0][0]==1||obstacleGrid[row-1][col-1]==1) return 0;

    k[0][0]=1;

    for(int i=1;i<row;++i)
        if(!obstacleGrid[i][0])
            k[i][0]=k[i-1][0];


    for(int j=1;j<col;++j)
        if(!obstacleGrid[0][j])
            k[0][j]=k[0][j-1];


    for(int i=1;i<row;++i)
        for(int j=1;j<col;++j)
    {
            if(!obstacleGrid[i][j])
                k[i][j]=k[i-1][j]+k[i][j-1];



    }
    return k[row-1][col-1];

}
};
