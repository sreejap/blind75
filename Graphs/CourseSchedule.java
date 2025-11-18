
// https://leetcode.com/problems/course-schedule/
// T(c) - O(m+n) -n, number of courses, m  - number of edges
// S(C) - O(m+n)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0) {
            return true;
        }

        int [] indegree = new int [numCourses];
        List <List<Integer>> adjList = new ArrayList <>();


         // STEP 1: initialize the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>()); // this is important, otherwise we get out of bounds or null pointer exceptions
        }

        Queue <Integer> courseQ = new LinkedList <>();

        for (int [] pre: prerequisites) {
            int c1 = pre[0];
            int c2 = pre[1];
            adjList.get(c2).add(c1); // Because the graph is directed, not undirected. You want to capture the dependency direction. You do NOT add the reverse edge, because:Taking course a does not mean you must take b.Only b → a matters.
            indegree[c1]++;
        }

        for (int i=0; i < indegree.length; i++){
            if (indegree[i] == 0) {
                courseQ.offer (i);
            }
        }
        int taken = 0;
      // so here we poll from the queue the course we are ready to take, so we increment taken
      // then we go through all neighbors and decreease indegree when indegree is 0 we add to the qu
      // that way we keep taking courses and when taken equals numcourses we return that we can take all courses
        while (!courseQ.isEmpty()){
            int qSize = courseQ.size();
            for (int i=0; i < qSize; i++){
                int c = courseQ.poll();
                taken++;
                for (Integer n : adjList.get(c)) {
                    indegree[n]--;
                    if (indegree[n] == 0){
                        courseQ.offer(n);
                    }
                }                
            }
            
        }

        return taken == numCourses;        

    }
}
