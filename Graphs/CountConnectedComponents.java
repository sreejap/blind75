// Count Connected Components in Network, Given n computers labeled 0 to n-1 and a list of bidirectional communication links, find the number of connected components.
// Example: Input n = 4, links = [[0, 1], [2, 3]], Output 
// T(C) - O(n+m), S(C) - O(n+m)

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'countIsolatedCommunicationGroups' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY links
     *  2. INTEGER n
     */
    // static int isolatedCommunicationGroups;
    public static List <List<Integer>> getAdjList (List<List<Integer>> links, int n) {
        // make adj list
        List <List<Integer>> adjList = new ArrayList <>();
        for (int i=0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for (List<Integer> link: links) {
            int a = link.get(0);
            int b = link.get(1);
            adjList.get(a).add(b) ;
            adjList.get(b).add(a) ;
        }
        return adjList;
    }
    
    public static int countIsolatedCommunicationGroups(List<List<Integer>> links, int n) {
        
        List <List <Integer>> adjList = getAdjList (links,n);
        boolean [] visited = new boolean[n]; 
        
        int isolatedCommunicationGroups = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                isolatedCommunicationGroups++;
                dfs(adjList, visited, i);
            }
        }
        return isolatedCommunicationGroups;


    }
    
    public static void dfs (List <List <Integer>> adjList,boolean [] visited, int start ) {
        
        if (visited[start]){
            return;
        }
        
        visited[start] = true;
        for (Integer nb : adjList.get(start)){
            if (!visited[nb]){                
                dfs (adjList, visited, nb);
               
               
            }
        }
        
    }

}
