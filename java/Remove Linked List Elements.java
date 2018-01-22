// 203. Remove Linked List Elements   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 94030
// Total Submissions: 303828
// Difficulty: Easy
// Contributors: Admin
// Remove all elements from a linked list of integers that have value val.

// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5

// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.

// Show Tags
// Show Similar Problems


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next!=null){
            if (p.next.val == val) {
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return dummy.next;
    }
}