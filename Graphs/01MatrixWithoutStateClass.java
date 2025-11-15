class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] dist = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        // Add all 0s to queue (multi-source BFS)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    q.offer(new int[] { r, c });
                    visited[r][c] = true;
                }
            }
        }

        int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };

        // BFS
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // valid check
                if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || visited[nr][nc]) {
                    continue;
                }

                // distance = parent distance + 1
                dist[nr][nc] = dist[r][c] + 1;

                visited[nr][nc] = true;
                q.offer(new int[] { nr, nc });
            }
        }

        return dist;
    }
}
