// 2. Add Two Numbers QuestionEditorial Solution  My Submissions
// Total Accepted: 229253
// Total Submissions: 873697
// Difficulty: Medium
// Contributors: Admin
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) -> 3
// Output: 7 -> 0 -> 8

// 342 + 465 = 807

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// dummy  0->7->0->8


// easy
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        ListNode p1 = l1, p2 = l2;
        int carry = 0;

        while(p1!=null || p2!=null){
        	int num1 = p1==null?0:p1.val;
        	int num2 = p2==null?0:p2.val;

        	int sum = num1 + num2 + carry;
        	p.next = new ListNode(sum%10);
        	carry = sum/10;

        	p1 = p1==null?null:p1.next;
        	p2 = p2==null?null:p2.next;
        	p = p.next;
        }

        if (carry == 1) p.next = new ListNode(1);

        return dummy.next;
    }
}