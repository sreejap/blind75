// https://leetcode.com/problems/merge-intervals/submissions/1832746544/
// T(C) - O(nlogn), S(C) - O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals == null || intervals [0].length ==0){
            return new int [0][0];
        }

        if (intervals.length == 1) {
            return intervals;
        }

        List <int[]> merged = new ArrayList <>();
        Arrays.sort (intervals, (a,b) -> (a[0] - b[0]));

        int [] curr = intervals [0];

        for (int i=1; i < intervals.length; i++) {
            if (intervals[i][0] <= curr [1]) {
                curr [0] = Math.min( curr[0] ,intervals[i][0]);
                curr [1] = Math.max (curr[1], intervals [i][1]);                
            } else {
                merged.add(curr);
                curr = intervals[i];
            }
        }

        merged.add(curr);

        return merged.toArray(new int [merged.size()][]);        
        
    }
}
