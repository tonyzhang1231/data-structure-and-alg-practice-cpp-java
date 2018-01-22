class Solution {
public:
    string minWindow(string s, string t) {

        vector<int> map(256, 0);
        int count = t.length();
        for (auto c:t){
            map[c]++;
        }

        int begin=0, end=0, head=0, d=INT_MAX;
        while (end<s.length()){

            if (end<s.length() && map[s[end++]]-->0 ){
                count--;
            }

            while (count==0){
                if (end - begin < d){
                    d = end - begin;
                    head = begin;
                }


                if (begin<s.length() && map[s[begin++]]++==0){
                    count++;
                }


            }


        }
        return d==INT_MAX?"": s.substr(head,d);


    }
};
