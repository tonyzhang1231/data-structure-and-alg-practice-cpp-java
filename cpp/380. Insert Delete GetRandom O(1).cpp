class RandomizedSet {
public:
    /** Initialize your data structure here. */
    unordered_map<int, int> map;
    vector<int> list;
    
    RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val) {
        if (map.find(val)!=map.end()) return false;
        map[val] = list.size();
        list.push_back(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val) {
        if (map.find(val)==map.end()) return false;
        int index = map[val];
        int lastVal = list.back();
        list[index] = lastVal;
        list.pop_back();
        map[lastVal] = index;
        map.erase(val);
        return true;
    }
    
    /** Get a random element from the set. */
    int getRandom() {
        return list[std::rand() % list.size()];
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * bool param_1 = obj.insert(val);
 * bool param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */