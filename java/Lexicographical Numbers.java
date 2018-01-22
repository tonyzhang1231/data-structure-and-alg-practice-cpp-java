// 386. Lexicographical Numbers   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 12434
// Total Submissions: 31537
// Difficulty: Medium
// Contributors: Admin
// Given an integer n, return 1 - n in lexicographical order.

// For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

// Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

// Subscribe to see which companies asked this question

public class Solution {
	public List<Integer> lexicalOrder(int n) {
	    List<Integer> list = new ArrayList<>(n);
	    int curr = 1;
	    for (int i = 1; i <= n; i++) {
	        list.add(curr);
	        if (curr * 10 <= n) {
	            curr *= 10;
	        } else if (curr % 10 != 9 && curr + 1 <= n) {
	            curr++;
	        } else {
	            while ((curr / 10) % 10 == 9) { // curr has last digit ==9 or curr ==n, look at its second last
	        // 	while(curr % 10 == 9){
	                curr /= 10;
	            }
	            curr = curr / 10 + 1; // if second last is <9 , remember 999..9 must be the last digit
	            // curr++;
	        }
	    }
	    return list;
	}
}

n = 113

[1,10, 100, 101 102...109 11 110 111 112 113 12 13 14 15 16 17 18 19 2]

1 10 100 


