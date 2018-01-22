/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        // Given  1->2->3->4->5->NULL, m = 2 and n = 4,
        //        p  t        h
        // return 1->4->3->2->5->NULL.
        
        int count = n - m +1;
        if (count <=0) return head;
        
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        
        ListNode* p = dummy;
        for (int i=1;i<m;i++){ // p move forward m-1
            p = p->next;
        }
        
        ListNode* tail = p->next;
        
        for (int i=0;i<n;i++){ // head move forward n
            head = head->next;
        }
        
        p->next = reverse(tail, count);
        tail->next = head;
        
        return dummy->next;
    }
    
    ListNode* reverse(ListNode* node, int count){
        ListNode* prev = nullptr;
        while(count-->0){
            ListNode* next = move(node->next);
            node->next = move(prev);
            prev = move(node);
            node = move(next);
        }
        return prev;
    }
    
    
};