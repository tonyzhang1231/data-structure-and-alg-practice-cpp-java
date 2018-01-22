// LinkedList Cycle


// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Note: Do not modify the linked list.

// Follow up:
// Can you solve it without using extra space?

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


// cycle 1 is easier, if (slow==fast) return true


public class Solution {
    public ListNode detectCycle(ListNode head) {
    	if (head==null||head.next==null) return null;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow==fast) break;
        }
        if (fast==null || fast.next==null) return null; // no cycle

        // dist x = head - target node 
        // dist y = target node - slow(fast)
        // len of cycle is l
        // fast goes x+y + kl 
        // slow goes x + y 
        // 2(x+y) = x+y +kl => kl = x+y => x = kl - y 
        slow = head;
        while(slow!=fast){
        	slow = slow.next;
        	fast = fast.next;
        }
        return slow;
    }
}