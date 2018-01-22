// 134. Gas Station   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 76094
// Total Submissions: 266211
// Difficulty: Medium
// Contributors: Admin
// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
// You begin the journey with an empty tank at one of the gas stations.

// Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

// Note:
// The solution is guaranteed to be unique.

// Subscribe to see which companies asked this question


public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int n=gas.length;
        for (int i=0;i<n;i++){
        	sum += gas[i] - cost[i];
        }
        if (sum<0) return -1;

        // can complete the circular route
        int start = 0;
        sum = 0;
        for (int i=0;i<n;i++){
        	sum += gas[i] - cost[i];
        	if (sum<0){
        		start = i+1;
        		sum = 0;
        	}
        }
        return start;

        // gas  1 2 3 4 5
        // cost 5 2 4 3 1

    }
}