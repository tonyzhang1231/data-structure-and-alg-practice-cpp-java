// 442. Find All Duplicates in an Array   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 10772
// Total Submissions: 22544
// Difficulty: Medium
// Contributors: shen5630
// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

// Find all the elements that appear twice in this array.

// Could you do it without extra space and in O(n) runtime?

// Example:
// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [2,3]

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
         List<Integer> result = new ArrayList<Integer>();
        if(nums == null)
            return result;
        for(int i=0; i<nums.length; i++){
            int location = Math.abs(nums[i])-1;
            if(nums[location] < 0){
                result.add(Math.abs(nums[i]));
            }else{
                nums[location] = -nums[location];
            }
        }
        for(int i=0; i<nums.length; i++)
            nums[i] = Math.abs(nums[i]);
       
        return result;
    }
}