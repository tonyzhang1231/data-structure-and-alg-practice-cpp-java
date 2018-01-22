// 241. Different Ways to Add Parentheses   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 36581
// Total Submissions: 88675
// Difficulty: Medium
// Contributors: Admin
// Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


// Example 1
// Input: "2-1-1".

// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Output: [0, 2]


// Example 2
// Input: "2*3-4*5"

// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
// Output: [-34, -14, -10, -10, 10]

// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.

// Subscribe to see which companies asked this question

// Show Tags
// Hide Similar Problems (M) Unique Binary Search Trees II (H) Basic Calculator (H) Expression Add Operators


// O(n^3) time O(n^2) space, n is the length of the input
class Solution {
    HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if (input==null || input.length()==0){
            return res;
        }
        
        if (map.containsKey(input)) return map.get(input);
        
        for (int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if (c=='+'||c=='-'||c=='*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int l:left){
                    for (int r:right){
                        if (c=='+') res.add(l+r);
                        else if (c=='-') res.add(l-r);
                        else if (c=='*') res.add(l*r);
                    }
                }
            }
        }
        if (res.size()==0)  res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }
}

// return all the strings
// Input: "2*3-4*5"

// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10

class Solution {
    public List<String> diffWaysToCompute(String input){
        return diffWaysToCompute(input, new HashMap<String, List<String>>());
    }
    List<String> diffWaysToCompute(String input, HashMap<String, List<String>> map) {
        List<String> res = new ArrayList<String>();
        if (input==null || input.length()==0){
            return res;
        }
        
        if (map.containsKey(input)) return map.get(input);
        
        for (int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if (c=='+'||c=='-'||c=='*'){
                List<String> left = diffWaysToCompute(input.substring(0,i));
                List<String> right = diffWaysToCompute(input.substring(i+1));
                for (String l:left){
                    for (String r:right){
                        // if (c=='+') res.add(l+ r);
                        // else if (c=='-') res.add(l-r);
                        // else if (c=='*') res.add(l*r);
                        // else if (c=='/' && r!=0) 
                        res.add(new StringBuilder('(').append(l).append(c).append(r).append(')').toString());
                    }
                }
            }
        }
        if (res.size()==0)  res.add(input);
        map.put(input, res);
        return res;
    }
}



// dp
public class Solution {
    String op="";
    ArrayList<Integer> ar=new ArrayList();
    ArrayList<Integer>[][] dp;
    ArrayList<Integer> dfs(int s,int t)
    {
        if(dp[s][t].size()>0) return dp[s][t];
        ArrayList<Integer> ans=new ArrayList<>();
        if(s==t)
        {
            ans.add(ar.get(s));
            dp[s][t]=ans;
            return ans;
        }
        for(int k=s;k<t;k++)
        {
            ArrayList<Integer> left=dfs(s,k);
            ArrayList<Integer> right=dfs(k+1,t);
            for(int i=0;i<left.size();i++)
            for(int j=0;j<right.size();j++)
            {
                int a=left.get(i);
                int b=right.get(j);
                ans.add(op.charAt(k)=='+'?a+b:(op.charAt(k)=='-'?a-b:a*b));
            }
        }
        dp[s][t]=ans;
        return ans;
    }
    public List<Integer> diffWaysToCompute(String input) {
         int v=-1;
         
         for(int i=0;i<input.length();i++)
         {
             if(Character.isDigit(input.charAt(i)))
             {
                 if(v==-1) v=0;
                 v=v*10+(int)input.charAt(i)-(int)'0';
             }else
             {
                 op+=input.charAt(i);
                 ar.add(v);v=-1;
             }
         }
         
         if(v!=-1)
         ar.add(v);
         int n=ar.size();
         dp=new ArrayList[n][n];
         for(int i=0;i<n;i++)
         for(int j=0;j<n;j++) dp[i][j]=new ArrayList<Integer>();
         return dfs(0,ar.size()-1);
    }
}