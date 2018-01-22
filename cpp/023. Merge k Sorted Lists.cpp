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

    struct compare {
        bool operator()(const ListNode* l, const ListNode* r) {
            return l->val > r->val;
        }
    };

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode *, vector<ListNode *>, compare> pq;
        for (auto& l:lists){
            if(l) pq.push(l);
        }

        ListNode* res = new ListNode(-1);
        ListNode* p = res;
        while (!pq.empty()){
            ListNode* t = pq.top();
            pq.pop();
            p-> next = new ListNode(t->val);
            p = p->next;
            if (t->next) pq.push(t->next);
        }

        return res->next;

    }
};
