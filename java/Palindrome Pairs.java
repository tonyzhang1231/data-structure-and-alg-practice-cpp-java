// 336. Palindrome Pairs   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 18926
// Total Submissions: 76616
// Difficulty: Hard
// Contributors: Admin
// Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

// Example 1:
// Given words = ["bat", "tab", "cat"]
// Return [[0, 1], [1, 0]]
// The palindromes are ["battab", "tabbat"]
// Example 2:
// Given words = ["abcd", "dcba", "lls", "s", "sssll"]
// Return [[0, 1], [1, 0], [3, 2], [2, 4]]
// The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words.length==0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i=0;i<words.length;i++){
            map.put(reverse(words[i]),i);
        }
        
        for (int j=0;j<words.length;j++){
            String word = words[j];
            for (int k=0;k<=word.length();k++){
                String first = word.substring(0,k), second = word.substring(k);
                if (isPal(first) && map.containsKey(second) && map.get(second)!=j) {
                    res.add(Arrays.asList(map.get(second),j));
                }
                if (isPal(second) && map.containsKey(first) && map.get(first)!=j && second.length()>0) {
                    res.add(Arrays.asList(j,map.get(first)));
                }
            }
        }
        return res;
    }
    
    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    
    public boolean isPal(String s){
        int i=0, j= s.length()-1;
        while(i<j){
            if (s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
    
}


public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> ret = new ArrayList<>(); 
    if (words == null || words.length < 2) return ret;
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i=0; i<words.length; i++) map.put(words[i], i);
    for (int i=0; i<words.length; i++) {
        // System.out.println(words[i]);
        for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
            String str1 = words[i].substring(0, j);
            String str2 = words[i].substring(j);
            if (isPalindrome(str1)) {
                String str2rvs = new StringBuilder(str2).reverse().toString();
                if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(map.get(str2rvs));
                    list.add(i);
                    ret.add(list);
                    // System.out.printf("isPal(str1): %s\n", list.toString());
                }
            }
            if (isPalindrome(str2)) {
                String str1rvs = new StringBuilder(str1).reverse().toString();
                // check "str.length() != 0" to avoid duplicates
                if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(map.get(str1rvs));
                    ret.add(list);
                    // System.out.printf("isPal(str2): %s\n", list.toString());
                }
            }
        }
    }
    return ret;
}

private boolean isPalindrome(String str) {
    int left = 0;
    int right = str.length() - 1;
    while (left <= right) {
        if (str.charAt(left++) !=  str.charAt(right--)) return false;
    }
    return true;
}

// ["abcd", "dcba", "lls", "s", "sssll"]
// map = {
// 	abcd,
// 	dcba,
// 	lls
// 	s
// 	sssll
// }

// abcd => str1 str2 = ["" "abcd",  "a" "bcd",  "ab" "cd",  "abc" "d", "abcd" ""]
// if (str1 is pal){
// 	if (reverse(str2) in map && get(reverse(str2)) is not self)  
// }
