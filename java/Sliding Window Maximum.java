// 239. Sliding Window Maximum   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 47684
// Total Submissions: 151667
// Difficulty: Hard
// Contributors: Admin
// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Therefore, return the max sliding window as [3,3,5,5,6,7].

// Note: 
// You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

// Follow up:
// Could you solve it in linear time?

// Hint:

// How about using a data structure such as deque (double-ended queue)?
// The queue size need not be the same as the window’s size.
// Remove redundant elements and the queue should store only elements that need to be considered.
// Subscribe to see which companies asked this question

// Hide Tags Heap
// Hide Similar Problems (H) Minimum Window Substring (E) Min Stack (H) Longest Substring with At Most Two Distinct Characters (H) Paint House II

public class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] res = new int[n-k+1];
		int index = 0;

		// store index in the ArrayDeque
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {

			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}

			// q.peek() is the index of curr largest number

			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}

			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				res[index++] = a[q.peek()];
			}
		}
		return res;
	}
}
