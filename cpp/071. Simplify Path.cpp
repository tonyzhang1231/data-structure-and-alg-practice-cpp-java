class Solution {
public:
    string simplifyPath(string path) {
        string res, token;
        vector<string> stk;
        stringstream ss(path);
        while (std::getline(ss, token, '/')){
            if (token=="" || token==".") continue;
            if (token==".." and !stk.empty()) stk.pop_back();
            else if (token!="..") stk.push_back(token);
        }
        
        for(auto& str : stk) res += "/"+str;
        return res.empty() ? "/" : res;
        
    }
};


// stringstream ss()
// http://en.cppreference.com/w/cpp/io/basic_stringstream

// std::getline()
// http://en.cppreference.com/w/cpp/string/basic_string/getline

// template< class CharT, class Traits, class Allocator >
// std::basic_istream<CharT,Traits>& getline( std::basic_istream<CharT,Traits>& input,
//                                            std::basic_string<CharT,Traits,Allocator>& str,
//                                            CharT delim );


// https://stackoverflow.com/questions/3292107/whats-the-difference-between-istringstream-ostringstream-and-stringstream-w