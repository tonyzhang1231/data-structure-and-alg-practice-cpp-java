// 151. Reverse Words in a String   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 135968
// Total Submissions: 864290
// Difficulty: Medium
// Contributors: Admin
// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Update (2015-02-12):
// For C programmers: Try to solve it in-place in O(1) space.

// click to show clarification.

// Clarification:
// What constitutes a word?
// A sequence of non-space characters constitutes a word.
// Could the input string contain leading or trailing spaces?
// Yes. However, your reversed string should not contain leading or trailing spaces.
// How about multiple spaces between two words?
// Reduce them to a single space in the reversed string.
// Subscribe to see which companies asked this question


public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i=strs.length-1;i>=1;i--){
            sb.append(strs[i] + " ");
        }
        sb.append(strs[0]);
        return sb.toString();
    }
}

// O(n) time and O(n) space




// Java String is immutable
186. Reverse Words in a String II   


	public void reverseWords(char[] s){
		reverseWords(s,0,s.length-1);
		for(int i = 0, j = 0;i <= s.length;i++){
			if(i==s.length || s[i] == ' '){
				reverseWords(s,j,i-1);
				j = i+1;
			}
		}
	}

	private void reverseWords(char[] s, int begin, int end){
		while(begin < end){
			char c = s[begin];
			s[begin] = s[end];
			s[end] = c;
			begin++;
			end--;
		}
	}



public void reverseWords(char[] s) {
    reverse(s, 0, s.length-1);  // reverse the whole string first
    int r = 0;
    while (r < s.length) {
        int l = r;
        while (r < s.length && s[r] != ' ')
            r++;
        reverse(s, l, r-1);  // reverse words one by one
        r++;
    }
}

public void reverse(char[] s, int l, int r) {
    while (l < r) {
        char tmp = s[l];
        s[l++] = s[r];
        s[r--] = tmp;
    }
}