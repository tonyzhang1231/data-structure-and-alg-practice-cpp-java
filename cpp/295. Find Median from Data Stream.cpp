// Here multiset is used, only trick is that keep track of middle element when a new element is inserted.
// if new element is greater of equal to middle element and number of element is now even then after inserting increment the middle, similarly if new element is smaller and number of element is odd then decrement middle.

// here is c++ code

// solution 1: use multiset (red black tree)

#include "000LCHeader.h"

using namespace std;

class MedianFinder {
public:
    /** initialize your data structure here. */
    multiset<int> A;
    int n;
    multiset<int>::iterator mid;
    
    MedianFinder() {
        A.clear();
        n = 0;
        mid = A.end();
    }
    
    void addNum(int num) {
        A.insert(num);
        n++;
        if (n==1) mid = A.begin();
        else if (num >= *mid && n%2==1) mid++;
        else if (num < *mid && n%2==0) mid--;
    }
    
    double findMedian() {
        if (n%2==1) return *mid;
        auto next = std::next(mid,1);
        return ( (double) (*next) + (double) (*mid) )/2;
    }
};

int main(){
    MedianFinder obj;
    obj.addNum(1);
    cout << obj.findMedian() << endl;
    obj.addNum(2);
    cout << obj.findMedian() << endl;
    obj.addNum(3);
    cout << obj.findMedian() << endl;
    obj.addNum(4);
    cout << obj.findMedian() << endl;
}


// g++ -std=c++14 -g -Wall 295.\ Find\ Median\ from\ Data\ Stream.cpp -o out.o

// 1
// 1.5
// 2
// 2.5

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */





// // solution 2, use pq
// class MedianFinder {
// public:
//     /** initialize your data structure here. */
//     MedianFinder() {}
    
//     void addNum(int num) {
//         (left.empty() || num <= left.top()) ? left.push(num) : right.push(num);
//         if(left.size() > right.size() + 1){
//             right.push(left.top());
//             left.pop();
//         }
//         if(right.size() > left.size()){
//             left.push(right.top());
//             right.pop();
//         }
//     }
    
//     double findMedian() {
//         return left.size() > right.size()? left.top() : (left.top() + right.top()) / 2.0;
//     }

// private:
//     priority_queue<int> left;
//     priority_queue<int, vector<int>, greater<int>> right;
// };


