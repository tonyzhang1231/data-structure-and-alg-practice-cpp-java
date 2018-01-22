#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int largestRectangleArea(vector<int> &height) {

        int ret = 0;
        height.push_back(0); // pad a 0 in the end
        vector<int> index;

        for(int i = 0; i < height.size(); i++)
        {   
            // std::cout << index.size() << endl;
            while(index.size() > 0 && height[index.back()] > height[i]) 
            {
                int h = height[index.back()];
                index.pop_back();

                int prev_idx = index.size() > 0 ? index.back() : -1; // the heights between prev_idx and i are >= h
                if(h * (i-prev_idx-1) > ret)
                    ret = h * (i-sidx-1);
            }
            index.push_back(i);
        }

        return ret;
    }
};

// pass 一遍所有的height， 如果比stack中top那个要高，直接放入stack中，否则结算， 去掉那些《=当前height， width 从prev_index 到当前index i
// 之所以要选择prev_index 是因为 prev_index 到 i 直接的height 》= h


int main(){
    Solution o;
    vector<int> height = {1};
    std::cout << o.largestRectangleArea(height) << endl;
}

// g++ -std=c++11 084.\ Largest\ Rectangle\ in\ Histogram.cpp -o out.o
// ./out.o