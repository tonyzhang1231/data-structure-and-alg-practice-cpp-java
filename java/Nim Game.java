// 292. Nim Game   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 116130
// Total Submissions: 212555
// Difficulty: Easy
// Contributors: Admin
// You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

// Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

// For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

// Hint:

// If there are 5 stones in the heap, could you figure out a way to remove the stones such that you will always be the winner?
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Hide Company Tags Adobe
// Hide Tags Brainteaser
// Hide Similar Problems (M) Flip Game II
// Have you met this question in a real interview? Yes  


public class Solution {
    public boolean canWinNim(int n) {
        return n%4!=0;
    }
}