

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        // 0-9, . , e, + - 
        boolean numberSeen= false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);   // judge the char one by one, if the cur char is digit(dot, e, + -) then do
            if (c>='0' && c<='9'){
                numberSeen = true;
                numberAfterE = true;
            }
            else if (c=='.'){
                if (pointSeen||eSeen) return false;
                pointSeen = true;  // 3. is valid, so is .3
            }
            else if (c=='e'){
                if (eSeen|| !numberSeen) return false;
                numberAfterE = false;
                eSeen = true;
            }
            else if (c=='+'||c=='-'){
                if (i!=0 && s.charAt(i-1)!='e' ) return false;
            }else{
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
}

// +1.23e-10