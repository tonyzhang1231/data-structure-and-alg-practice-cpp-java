wiggle sort


324. Wiggle Sort II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 22588
Total Submissions: 89649
Difficulty: Medium
Contributors: Admin
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Subscribe to see which companies asked this question



public class Solution {
	public void wiggleSort(int[] nums) {
		int median = findKthLargest(nums, (nums.length + 1) / 2);
		int n = nums.length;

		int left = 0, i = 0, right = n - 1;

		while (i <= right) {
            // like sort colors
			if (nums[newIndex(i, n)] > median) {
				swap(nums, newIndex(left++, n), newIndex(i++, n));
			} else if (nums[newIndex(i, n)] < median) {
				swap(nums, newIndex(right--, n), newIndex(i, n));
			} else {
				i++;
			}
		}

	}

	private int newIndex(int index, int n) {
		return (1 + 2 * index) % (n | 1);
	}

	public int findKthLargest(int[] a, int k) {
		int n = a.length;
		int p = quickSelect(a, 0, n - 1, n - k + 1); // kth largest number == n-k+1 th smallest number
		return a[p];
	}

	// return the index of the kth smallest number
	int quickSelect(int[] a, int lo, int hi, int k) {
		// use quick sort's idea
		// put nums that are <= pivot to the left
		// put nums that are > pivot to the right
		int i = lo, j = hi, pivot = a[hi];
		while (i < j) {
			if (a[i++] > pivot)
				swap(a, --i, --j);
		}
		swap(a, i, hi);

		// count the nums that are <= pivot from lo
		int m = i - lo + 1;

		// pivot is the one!
		if (m == k)
			return i;
		// pivot is too big, so it must be on the left
		else if (m > k)
			return quickSelect(a, lo, i - 1, k);
		// pivot is too small, so it must be on the right
		else
			return quickSelect(a, i + 1, hi, k - m);
	}

	void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}



// 280. Wiggle Sort   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 22292
// Total Submissions: 40514
// Difficulty: Medium
// Contributors: Admin
// Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

// For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].


public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i=0;i<nums.length;i++)
            if(i%2==1){
               if(nums[i-1]>nums[i]) swap(nums, i);
            }else if(i!=0 && nums[i-1]<nums[i]) swap(nums, i);
    }
    public void swap(int[] nums, int i){
          int tmp=nums[i];
          nums[i]=nums[i-1];
          nums[i-1]=tmp;
    }
}

// 125 / 125 test cases passed.
// Status: Accepted
// Runtime: 1 ms