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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode res(0);
        ListNode* p = &res;
        int carry = 0;
        
        while (l1 || l2){
            int sum = 0;
            if (l1) sum += l1->val;
            if (l2) sum += l2->val;
            sum += carry;
            p->next = new ListNode(sum%10);
            carry = sum/10;
                
            l1 = l1?l1->next:NULL;
            l2 = l2?l2->next:NULL;
            p = p->next;
            
        }
        if(carry == 1) p->next = new ListNode(1);
        return res.next;
    }
};