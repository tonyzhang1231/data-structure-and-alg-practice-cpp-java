class Solution {
public:
    int calculate(string s) {
        int n = s.size();
        int pre = 0;
        int res = 0;
        char sign = '+';
        
        for (int i=0;i<n;i++){
            
            if (isDigit(s[i])){
                int cur = s[i] - '0';
                while (i+1<n && isDigit(s[i+1])  ){
                    cur = cur * 10 + (s[i+1]-'0');
                    i++;
                }
                if (sign == '+'){
                    res += cur;
                    pre = cur;
                }else if (sign=='-'){
                    res -= cur;
                    pre = -cur;
                }else if (sign=='*'){
                    res = res - pre + pre * cur;
                    pre = pre * cur;
                }else if (sign == '/'){
                    res = res - pre + pre / cur;
                    pre = pre / cur;
                }
                
            }else if(s[i]=='+' || s[i]=='-' || s[i] =='*' || s[i] =='/'){
                sign = s[i];
            }else{
                continue;
            }
            
            
        }
        return res;
        
    }
    
    bool isDigit(char c){
        return c>='0' && c<='9';
    }
};