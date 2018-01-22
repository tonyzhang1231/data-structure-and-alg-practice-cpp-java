// 187. Repeated DNA Sequences   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 64505
// Total Submissions: 217769
// Difficulty: Medium
// Contributors: Admin
// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

// For example,

// Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

// Return:
// ["AAAAACCCCC", "CCCCCAAAAA"].


public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
	    Set seen = new HashSet(), repeated = new HashSet();
	    for (int i = 0; i + 9 < s.length(); i++) {
	        String ten = s.substring(i, i + 10);
	        if (!seen.add(ten))
	            repeated.add(ten);
	    }
	    return new ArrayList(repeated);
	}
}