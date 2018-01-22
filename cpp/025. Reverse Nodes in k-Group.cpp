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
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (!head) return head;
        
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* p = dummy;
        ListNode* tail = head;
        
        // 0  1 2 3 4 5
        // dp t   h 
        while (true){
            int count = 0;
            while(head && count <k){
                head = head->next;
                count++;
            }
            if (count<k) break;
            p->next = reverse(tail, count);
            p = tail;
            tail->next = head;
            tail = head;
            
        }
        
        
        
        
        return dummy->next;
        
    }
    
    ListNode* reverse(ListNode* node, int count){
        ListNode* prev = nullptr;
        while (count){
            ListNode* next = move(node->next);
            node->next = move(prev);
            prev = move(node);
            node = move(next);
            count--;
        }
        return prev;
    }
};