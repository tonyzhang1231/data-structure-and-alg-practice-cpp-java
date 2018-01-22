
palindrome partition

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s==null||s.length()==0) return res;
        // find all pal
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0;i < n;i++){
            int left = i, right= i;
            while(left >=0 && right <= n-1 && s.charAt(left)==s.charAt(right)){
                dp[left--][right++] = true;
            }
        }
        for (int i = 0;i < n-1;i++){
            int left = i, right= i+1;
            while(left >=0 && right <= n-1 && s.charAt(left)==s.charAt(right)){
                dp[left--][right++] = true;
            }
        }
        // dfs
        dfs(res, new ArrayList<String>(), s, dp, 0);
        return res;
        
    }
    
    void dfs(List<List<String>> res, List<String> temp, String s, boolean[][] dp, int start){
        if (start == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=start;i<s.length();i++){
            if (dp[start][i]){ // if start - i is a pal, do dfs
                temp.add(s.substring(start,i+1));
                dfs(res, temp, s, dp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    

}


public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s==null || s.length()==0) return res;
        
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        
        
        dfs(s, res, new ArrayList<>(), 0 , dp);
        return res;
    }
    
    public void dfs(String s, List<List<String>> res, List<String> temp, int start, boolean[][] dp){
        if (start==s.length()){
            res.add(new ArrayList<String>(temp));
            return;
        }
        
        for (int i=start;i<s.length();i++){
            // String str = s.substring(index,i);
            if (dp[start][i]) {
                temp.add(s.substring(start,i+1));
                dfs(s,res,temp,i+1,dp);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    boolean isPal(String s, int i, int j){
        while(i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }
}