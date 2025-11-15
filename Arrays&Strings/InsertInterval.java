// https://leetcode.com/problems/insert-interval/
// T(C) - O(n)
// S(C) - O(1)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int [][] {newInterval}; // this is empty
            //  return new int [][]; // this is empty ... we need dimension, this is not the righ syntax
        }        
        
        int n = intervals.length;
        List <int[]> res = new ArrayList <>();
        int i=0;

        while ( i <n &&  intervals[i][1] < newInterval[0] ){ // intervals ending before the new one starts
            // no overlap before merging         
            res.add (intervals[i]);           
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) { // new interval is in the middle of the current int we have overlap
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);            
            i++;
        }
        res.add(newInterval); // this is all merged
        
        while (i < n) {
            // add the remaining ones...
            res.add(intervals[i]);
            i++;
        }
        
        return res.toArray(new int [res.size()][]);
    }
}
