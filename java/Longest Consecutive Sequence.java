// 128. Longest Consecutive Sequence
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n:nums) set.add(n);
        
        int best = 0;
        for (int n:nums){
            if (!set.contains(n-1)){
                int m=n+1;
                while (set.contains(m)){
                    m++;
                }
                best = Math.max(best,m-n);
            }
        }
        return best;
    }
}