/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        vector<Interval> res;
        for (int i=0;i<intervals.size();i++){
            Interval& v = intervals[i];
            if(v.end < newInterval.start){
                res.push_back(move(v));
            }else if(v.start > newInterval.end){
                res.push_back(move(newInterval));
                newInterval = move(v);
            }else{
                newInterval.start = min(v.start, newInterval.start);
                newInterval.end = max(v.end, newInterval.end);
            }
        }
        res.push_back(move(newInterval));
        return res;
    }
};