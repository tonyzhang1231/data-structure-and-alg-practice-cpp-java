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
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head) return head;
        
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        ListNode* p = dummy;
        
        while (head){
            if (head->next && head->val == head->next->val){
                while (head->next && head->val == head->next->val){
                    head = head ->next;
                }
                head = head ->next;
                p -> next = head; // if dup is found, don't move p
            }else{
                head = head ->next; 
                p = p->next; // if no dup is found, move p
            } 
        }
        return dummy->next;
            
            
    }
};