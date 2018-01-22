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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* res = new ListNode(0);
        ListNode* head = res; // this is a copy of a ptr
        while (l1||l2){
            if (l1 && l2){
                if (l1->val < l2->val){
                    res->next = new ListNode(l1->val);
                    l1 = l1->next;
                }else{
                    res->next = new ListNode(l2->val);
                    l2 = l2->next;
                }
            }else if(l1){
                res->next = new ListNode(l1->val);
                l1 = l1->next;
            }else{
                res->next = new ListNode(l2->val);
                l2 = l2->next;
            }
            res = res -> next;
        }

        return head->next;
    }
};
