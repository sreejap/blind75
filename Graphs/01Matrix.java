// https://leetcode.com/problems/01-matrix/
// T(C) - o(m*n), S(C) - o(m*n)
// intuition - multisource BFS - we are adding all 0s to queue to start with and then we do bfs on that queue and update the distance at each level which is distance to each 0 , using the state class and we make sure we don't visit the previous cells

class State {
    int row;
    int col;
    int steps;

    State (int r, int c, int s) {
        row = r;
        col = c;
        steps = s;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat[0].length == 0){
            return new int [0][]; // empty array
        }
        
        int rows = mat.length;
        int cols = mat[0].length;
        int [][] matrix = new int [rows][cols];
        boolean [][] visited = new boolean [rows][cols]; // q: do we have to init this? no

        int [][] directions = new int [][] {{0,1}, {1,0}, {0,-1},{-1,0}};
        // queue for state and put all the 0s in q

        Queue <State> cells = new LinkedList <>();
        for (int i=0; i < rows; i++){
            for (int j=0; j < cols; j++){
                if (mat[i][j] == 0 ){
                    cells.offer ( new State (i,j,0)); // important: when we add to queue, we mark as visited 
                    visited [i][j] = true;
                }
            }
        }

        while (cells.size()!=0) {
            int qSize = cells.size();
            for (int i=0; i < qSize; i++) {    // for that level start polling            
                State s = cells.poll();
                for (int []d : directions) { // now find neighbors in all directions
                    int newX = s.row + d[0];
                    int newY = s.col + d[1];

                    if (newX <0 || newY <0 || newX >= rows || newY >= cols || visited [newX][newY]) { // is valid
                        continue;
                    }
                    visited [newX][newY] = true; // mark as visited
                    int level = s.steps + 1;
                    cells.offer(new State (newX, newY, level)); // add back with updated steps..
                    matrix[newX][newY] = level;
                }
            }
        }

        return matrix;
    }
}
