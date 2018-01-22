// 315. Count of Smaller Numbers After Self   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 25049
// Total Submissions: 74758
// Difficulty: Hard
// Contributors: Admin
// You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

// Example:

// Given nums = [5, 2, 6, 1]

// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.
// Return the array [2, 1, 1, 0].

//  Google
// Hide Tags Divide and Conquer Binary Indexed Tree Segment Tree Binary Search Tree
// Hide Similar Problems (H) Count of Range Sum (M) Queue Reconstruction by Height


// BST 
// https://discuss.leetcode.com/topic/31405/9ms-short-java-bst-solution-get-answer-when-building-bst/2
public class Solution {
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}


// bit
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i]:min;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i],max);
        }
        int[] tree = new int[max+1];
        for (int i = nums2.length-1; i >= 0; i--) {
            res.add(0,get(nums2[i]-1,tree));
            update(nums2[i],tree);
        }
        return res;
    }
    private int get(int i, int[] tree) {
        int num = 0;
        while (i > 0) {
            num +=tree[i];
            i -= i&(-i);
        }
        return num;
    }
    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i] ++;
            i += i & (-i);
        }
    }
}


public class Solution {
	class BIT {
		int n;
		int[] bit;

		BIT(int size) {
			this.n = size + 1;
			this.bit = new int[this.n];
		}

		void update(int i) {
			while (i <= n - 1) {
				bit[i]++;
				i = i + (i & -i);
			}
		}

		int sum(int i) {
			int ans = 0;
			while (i > 0) {
				ans += bit[i];
				i = i - (i & -i);
			}
			return ans;
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> counts = new LinkedList<Integer>();

		if (nums == null || nums.length == 0)
			return counts;

		int[] orderedNums = nums.clone();
		Arrays.sort(orderedNums);
		int[] nums2 = IntStream.of(nums)
				.map(x -> Arrays.binarySearch(orderedNums, x) + 1).toArray();

		BIT bit = new BIT(nums2.length);
		for (int i = nums2.length - 1; i >= 0; i--) {
			counts.add(0, bit.sum(nums2[i]));
			bit.update(nums2[i] + 1);
		}

		return counts;
	}
}



// 3. merge sort
// The basic idea is to do merge sort to nums[]. 
// To record the result, we need to keep the index of each number in the original array. 
// So instead of sort the number in nums, we sort the indexes of each number.

// Example: nums = [5,2,6,1], indexes = [0,1,2,3]
// After sort: indexes = [3,1,0,2]

// While doing the merge part, say that we are merging left[] and right[], 
// left[] and right[] are already sorted.

// We keep a rightcount to record how many numbers from right[] 
// we have added and keep an array count[] to record the result.

// When we move a number from right[] into the new sorted array, we increase rightcount by 1.

// When we move a number from left[] into the new sorted array, we increase 
// count[ index of the number ] by rightcount.

class Solution {
    public List<Integer> countSmaller(int[] A) {
        int[] res = new int[A.length];
        int[] index = new int[A.length];
        for (int i=0;i<index.length;i++) index[i] = i;
        mergeSortWhileCount(A, index, 0 ,A.length, res);
        List<Integer> ret = new ArrayList<>();
        for (int i:res){
            ret.add(i);
        }
        return ret;
    }
    
    private void mergeSortWhileCount(int[] A, int[] index, int start, int end, int[] res){
        if (end - start <= 1) return;
        int mid = start + (end - start)/2;
        mergeSortWhileCount(A, index, start, mid, res);
        mergeSortWhileCount(A, index, mid, end, res);
        
        int[] cache = new int[end - start];
        int t = mid, j = mid;
        for (int i = start , r = 0; i<mid; i++, r++){

        	// can use binarySearch?
            while (j != end && A[index[i]] > A[index[j]]) ++j;
            res[index[i]] += j - mid;
            
            // mergesort
            while (t < end && A[index[t]] < A[index[i]]) cache[r++] = index[t++];
            cache[r] = index[i];
            
        }
        System.arraycopy(cache, 0, index, start, t - start); 
        
    }
}


// almost the same as 325 count of range sum
class Solution {
public:
    void sortCount(vector<int> &ans, vector<int> &nums, vector<int>::iterator begin, vector<int>::iterator end) {
        if (end - begin <= 1)
            return;
        
        auto mid = begin + (end - begin) / 2;
        sortCount(ans, nums, begin, mid);
        sortCount(ans, nums, mid, end);

        // for each i, count the small numbers on right part
        for (auto i = begin, j = mid; i != mid; ++i) {

        	// can be replaced by binary search, I think
            while (j != end && nums[*i] > nums[*j]) ++j;
                
            ans[*i] += j - mid; // added to result
        }

        // merge sort inplace 
        inplace_merge(begin, mid, end, [&](int a, int b) { return nums[a] < nums[b]; });
    }

    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n, 0), indexes(n);
        iota(indexes.begin(), indexes.end(), 0); // return 0,1,2...,n-1
        sortCount(ans, nums, indexes.begin(), indexes.end());
        return ans;
    }
};

