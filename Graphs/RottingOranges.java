// https://leetcode.com/problems/rotting-oranges/
// T(C) - O(n*m), S(C) - O(n*m)
// Intuition: Keep a counter freshCount for all fresh oranges in the grid. This helps to quickly check at the end if any fresh orange is left (return -1) — no need for a separate visited array.
// 2️⃣ Use a flag to track rotting in the current BFS level. During each BFS “minute” (level), use a boolean flag, e.g., rottedThisRound. Only set rottedThisRound = true when at least one fresh orange is rotted in this round.
// Increment time only if rottedThisRound is true. Why? If no new oranges rot in this level, we shouldn’t count it as an extra minute. This prevents overcounting time.
// 3️⃣ Update fresh count Each time a fresh orange rots, decrement freshCount. Once freshCount == 0, all oranges have rotted, and BFS can stop.
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> bfsQ = new LinkedList<>();

        int freshCount = 0; // track total fresh oranges

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    bfsQ.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0; // no fresh oranges

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int time = 0;

        while (!bfsQ.isEmpty()) {
            int qSize = bfsQ.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < qSize; i++) {
                int[] cell = bfsQ.poll();

                for (int[] d : dirs) {
                    int x = cell[0] + d[0];
                    int y = cell[1] + d[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
                    if (grid[x][y] != 1) continue;

                    // rot the orange
                    grid[x][y] = 2;
                    bfsQ.offer(new int[]{x, y});
                    freshCount--;
                    rottedThisRound = true;
                }
            }

            if (rottedThisRound) time++;
        }

        return freshCount == 0 ? time : -1;
    }
}
