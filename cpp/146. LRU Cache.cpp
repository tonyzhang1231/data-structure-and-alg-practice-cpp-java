class LRUCache {


private:
    struct Node{
        int key, val;
        Node* next;
        Node* prev;
        Node(int k, int v): key(k), val(v), prev(nullptr), next(nullptr){};
    }; // must have a ;

    std::unordered_map<int, Node*> _map;
    int _count;
    int _capacity;
    Node* _head;
    Node* _tail;

    void moveToHead(Node* node){
        deleteNode(node);
        addToHead(node);
    }

    void deleteNode(Node* node){
        Node* p = node->prev;
        Node* n = node->next;
        p->next = n;
        n->prev = p;
    }

    void addToHead(Node* node){
        Node* n = _head->next;
        _head->next = node;
        node->prev = _head;
        node->next = n;
        n->prev = node;
    }

public:
    LRUCache(int capacity) {
        _capacity = capacity;
        _count = 0;
        _head = new Node(-1,0);
        _tail = new Node(-1,0);
        _head->next = _tail;
        _tail->prev = _head;
    }

    int get(int key) {
        if (_map.find(key)!=_map.end()){
            Node* node = _map[key];
            moveToHead(node);
            return node->val;
        }
        return -1;
    }

    void put(int key, int value) {
        if (_map.find(key)!=_map.end()){
            Node* node = _map[key];
            node->val = value;
            moveToHead(node);
        }else{
            Node* node = new Node(key, value);
            // insert this node and add it to map
            _map[key] = node;
            addToHead(node);
            if (_count == _capacity){
                // remove the last, remove the node from the map
                Node* last = _tail->prev;

                _map.erase(last->key);
                deleteNode(last);

            }else{
                _count++;
            }
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
