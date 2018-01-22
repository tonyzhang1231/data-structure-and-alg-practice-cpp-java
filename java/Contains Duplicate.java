
// 219. Contains Duplicate II   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 91512
// Total Submissions: 290582
// Difficulty: Easy
// Contributors: Admin
// Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

// Subscribe to see which companies asked this question


public class Solution {
    public boolean containsNearbyDuplicate(int[] A, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(); // num -> index
        for (int i=0;i<A.length;i++){
            if (map.containsKey(A[i])) {
                int index = map.get(A[i]);
                if (i - index<=k) return true;
            }
            map.put(A[i],i);
        }
        return false;
    }
}




// 220. Contains Duplicate III   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 45142
// Total Submissions: 230989
// Difficulty: Medium
// Contributors: Admin
// Given an array of integers, find out whether there are two distinct indices i and j in the array such that 
// the absolute difference between nums[i] and nums[j] is at most t and the absolute difference 
// between i and j is at most k.
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}

// transform numbers to positive by minus minValue, and map the number to bucket, map.put(bucket,num)
// if another num comes, and we the also do the same thing, if we found its bucket already exists, => duplicated
// or previous or next bucket exists and differnce <= t
// if map.size()>=k, remove the lastbucket = (nums[i-k] - minValue)/ (t+1);

// This problem requires to maintain a window of size k of the previous values that can be queried 
// for value ranges. The best data structure to do that is Binary Search Tree. 
// 	As a result maintaining the tree of size k will result in time complexity O(N lg K). 
// In order to check if there exists any value of range abs(nums[i] - nums[j]) to simple queries 
// can be executed both of time complexity O(lg K)

Here is the whole solution using TreeMap.

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }
}