// 143. Reorder List   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 82139
// Total Submissions: 333548
// Difficulty: Medium
// Contributors: Admin
// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You must do this in-place without altering the nodes' values.

// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.

// Subscribe to see which companies asked this question

// Hide Tags Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null) return;
        
        // split the listnode
        // 1 2 3 4 (5) null
        // s s   
        //   f   f     
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newList = slow.next;
        slow.next = null;
        
        ListNode first = head;
        ListNode second = reverse(newList);
        
        // 1() 2(pre)
        // 4(p1) 3(next)
        // merge head and prev
        while(first!=null){
            ListNode next = first.next;
            first.next = second;
            second = next;
            first = first.next;
        }
        
        
    }

    public ListNode reverse(ListNode list){
        ListNode prev = null;
        while (list!=null){
            ListNode temp = list.next;
            list.next = prev;
            prev = list;
            list = temp;
        }
        return prev;
    }

}