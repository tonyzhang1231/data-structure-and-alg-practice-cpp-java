#include <iostream>
#include <vector>
#include <queue>
// #include <math>
using namespace std;


struct Interval {
  int start;
  int end;
  Interval() : start(0), end(0) {}
  Interval(int s, int e) : start(s), end(e) {}


};

// must be outside of struct
std::ostream& operator<<(std::ostream& os, const Interval& x){
	os<<  "[" << x.start << " " << x.end <<  "]" ;
	return os;
}


class Solution{
public:
	static int meetingrooms(vector<Interval>& ins){
		std::sort(ins.begin(), ins.end(), [](Interval a, Interval b){
			if (a.start==b.start ) return a.end < b.end;
			return a.start < b.start;
		});

		// for sort function, a < b => smallest to largest

		// for priority_queue, std::greater<T> => minHeap

		int res = 0;
		std::priority_queue<int, vector<int>, std::greater<int>> pq; // min heap needs greater<int>
		for (int i=0;i<ins.size();i++){
			while (!pq.empty() && ins[i].start >= pq.top()){
				pq.pop();
			}
			pq.push(ins[i].end);
			int sz = pq.size();
			res = std::max(res, sz);
		}
		return res;
	}
};


int main(){
	std::vector<Interval> ins;
	ins.emplace_back(0,2);
	ins.emplace_back(1,3);
	ins.emplace_back(2,5);
	ins.emplace_back(3,9);
	ins.emplace_back(4,6);
	for (auto& i:ins){
		cout<< i << '\n';
	}
	std::cout << Solution::meetingrooms(ins) << " == 3\n";

	return 0;
}

