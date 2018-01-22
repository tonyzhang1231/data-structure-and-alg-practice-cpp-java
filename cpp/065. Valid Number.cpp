class Solution {
public:
    bool isNumber(string s) {
        bool pointSeen = false;
        bool numSeen = false;
        bool eSeen = false;
        bool spaceAllowed = true;
        
        int start = 0;
        while (s[start]==' ') start++;
        if (start < s.size() && (s[start] == '+' ||s[start] == '-') ) start++;
        
        int i= start;
        for (;i<s.size();i++){
            auto& c = s[i];
            if (std::isdigit(c)){
                numSeen = true;
                
            }else if(c=='.'){
                if (pointSeen || eSeen) return false;
                pointSeen = true;
                // numSeen = false; // we need at least 1 number
            }else if(c=='e'){
                if (!numSeen || eSeen) return false;
                eSeen = true;
                numSeen = false; // we need at least 1 number
            }else if(c=='+' || c=='-'){
                if (s[i-1]!='e') return false;
            }
            else if (c==' '){
                break;
            }else{
                return false;
            }
        }
        
        if (!numSeen) return false;
        while (i<s.size()){
            if (s[i]!=' ') return false;
            i++;
        }
        
        return true;
        
    }
};



#include <string>
#include <regex>
using namespace std;

class Solution
{
public:
    bool isNumber(string s)
    {
        static const std::regex rg("^\\s*[+-]?((\\.?\\d+)|(\\d+\\.?\\d*))((e[+-]?)?\\d+)?\\s*$");
        return std::regex_match(s, rg);
    }   
};