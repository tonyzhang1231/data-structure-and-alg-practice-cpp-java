
// 55. Jump Game
// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// For example:
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.
// 6 line java solution in O(n)
// The basic idea is this: at each step, we keep track of the furthest reachable index. The nature of the problem (eg. maximal jumps where you can hit a range of targets instead of singular jumps where you can only hit one target) is that for an index to be reachable, each of the previous indices have to be reachable.

// Hence, it suffices that we iterate over each index, and If we ever encounter an index that is not reachable, we abort and return false. By the end, we will have iterated to the last index. If the loop finishes, then the last index is reachable.


public class Solution {
	public boolean canJump(int[] nums) {
	    int reachable = 0;
	    for (int i=0; i<nums.length; ++i) {
	        if (i > reachable) return false;
	        reachable = Math.max(reachable, i + nums[i]);
	    }
	    return true;
	}
}



public class Solution {
	public int jump(int[] A) {
		int step_count = 0;
		int last_jump_max = 0;
		int current_jump_max = 0;
		for(int i=0; i<A.length-1; i++) {
		    current_jump_max = Math.max(current_jump_max, i+A[i]);
		    // current_jump_max = Math.min(A.length-1,Math.max(current_jump_max, i+A[i]));
		    if( i == last_jump_max ) {

		        step_count++;
		        last_jump_max = current_jump_max;
		    } 
		}
		return step_count;
	}
}

public class Solution {
	public int jump(int[] A) {
		int step_count = 0;
		int last_jump_max = 0;
		int current_jump_max = 0;
		for(int i=0; i<A.length-1; i++) {
		    current_jump_max = Math.max(current_jump_max, i+A[i]);
		    if (current_jump_max>=A.length-1) return step_count+1;
		    // current_jump_max = Math.min(A.length-1,Math.max(current_jump_max, i+A[i]));
		    if( i == last_jump_max ) {
		        step_count++;
		        last_jump_max = current_jump_max;
		    } 
		}
		return 0;
	}
}

// Very elegant method, but it took me a long time to understand. Some comment for the above:

// e: longest distance in current minimum step

// sc: minimum steps for reaching e

// From i to e, even max is changed in a loop, it is reachable in one step.

// Help it will help : )