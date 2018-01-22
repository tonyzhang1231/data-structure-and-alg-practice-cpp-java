

169. Majority Element   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 165165
Total Submissions: 368761
Difficulty: Easy
Contributors: Admin
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Company Tags Adobe Zenefits
Hide Tags Array Divide and Conquer Bit Manipulation
Hide Similar Problems (M) Majority Element II
Have you met this question in a real interview? Yes  No
DiscussTop Solutions Pick One


public class Solution {
    public int majorityElement(int[] A) {
    	int res = 0, count = 0;
        for (int a:A){
        	if (a==res) count++;
        	else if (count>0){
        	    count--;
        	}else{
        		res = a;
        		count = 1;
        	}
        }
        return res;
    }
}

// one pass O(n) time and O(1) space











229. Majority Element II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 45323
Total Submissions: 163585
Difficulty: Medium
Contributors: Admin
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
Do you have a better hint? Suggest it!
Hide Company Tags Zenefits
Hide Tags Array
Hide Similar Problems (E) Majority Element
Have you met this question in a real interview? Yes  No
DiscussTop Solutions Pick One

public class Solution {
    public List<Integer> majorityElement(int[] A) {
    	List<Integer> res = new ArrayList<>();
        int res1 = 0, cnt1 = 0, res2 = 0, cnt2 = 0;
        for (int a:A){
        	if (a==res1){
        		cnt1++;
        	}else if (a==res2){
        		cnt2++;
        	}else if(cnt1==0){
        		cnt1=1;
        		res1 = a;
        	}else if(cnt2==0){
        		cnt2 = 1;
        		res2 = a;
        	}else{
        		cnt1--;cnt2--;
        	}
        }
        cnt1 = 0;
        cnt2 = 0; // res1 and res2 are possible to be the majority element, need to check again
        for (int a:A){
        	if (a==res1) cnt1++;
        	else if (a==res2) cnt2++;
        }
        if (cnt1>A.length/3) res.add(res1); 
        if (cnt2>A.length/3) res.add(res2);
        return res;
    }
}


1 1 1 2 2 2 3 4
