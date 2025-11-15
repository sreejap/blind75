// https://leetcode.com/problems/k-closest-points-to-origin/
// T(C) - O(NlogK), S(C)- O(K)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // we use a max heap
        // we need a function to calculate the distance
        if (points == null || points[0].length == 0){
            return new int [0][];
        }

        PriorityQueue <int []> pq = new PriorityQueue <> ( (a,b) -> b[0] - a[0]); // correct syntax -> not - >
        // we store the distance and index in the points
        for ( int i=0; i < points.length; i++) {
            int pointDist = dist (points[i]);
            if (pq.size() < k) {
                pq.offer(new int [] {pointDist, i});
            }
            else {                
                if (pq.peek() [0] > pointDist) {
                    pq.poll();
                    pq.offer (new int [] {pointDist,i});
                }
            }
        }

        int [][] kClosest = new int [k][];

        for (int i=0; i < k; i++){

            kClosest [i] = points[pq.poll()[1]]; // put the right values in the return
        }
        return kClosest;
    }

    public int dist (int [] point) {
        return point[0] * point[0] + point [1] * point [1];
    }
}
