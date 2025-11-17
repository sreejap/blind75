// https://leetcode.com/problems/maximum-profit-in-job-scheduling/
// T(C) - Time complexity: O(NlogN)
// Space complexity: O(N)

class Solution {
    int[] memo = new int[50001];

    private int findNextJob (int [] startTime, int lastEndingTime) {
        int lo = 0;
        int hi = startTime.length-1;
        int nextIndex = startTime.length; // this is the sentinel

        while (lo <=hi) {
            int mid = (lo + (hi-lo)/2);
            if (startTime [mid] >= lastEndingTime) {
                nextIndex = mid;
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return nextIndex;
    }

    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime, int n, int position) {
        if (position == n) {
            return 0; // if we are are position n, DP returns 0
        }

        if (memo[position]!=-1) {
            return memo [position];
        }
        // find next index of the next non-conflicting job
        int nextIndex = findNextJob (startTime, jobs.get(position).get(1));

        int maxProfit = Math.max (findMaxProfit(jobs,startTime, n, position+1), jobs.get(position).get(2) + findMaxProfit (jobs,startTime, n, nextIndex));
        return memo [position] = maxProfit;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List <List<Integer>> jobs = new ArrayList <>();        
        Arrays.fill(memo,-1);

        for (int i=0; i < profit.length; i++){
            ArrayList <Integer> job = new ArrayList <>();
            job.add(startTime[i]);
            job.add(endTime[i]);
            job.add(profit[i]);
            jobs.add(job);
        }

        jobs.sort ((a,b)-> a.get(0) - b.get(0));
        Arrays.sort (startTime);

        return findMaxProfit (jobs, startTime, profit.length,0);
    }
}
