// https://leetcode.com/problems/word-ladder/
//  chars.toString(); is incorrect
// T(C) - O(N*L) -- n number of words, l length of words
// S(C) - O(N*L)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // we can do this

        int ladderLength = 0;
        Queue <String> bfsQ = new LinkedList <>();
        Set <String> words = new HashSet <>(wordList); 

        if (!words.contains(endWord)){
            return ladderLength;
        }

        Set <String> visited = new HashSet <>();
        ladderLength = 1;
        bfsQ.offer(beginWord);
        visited.add (beginWord);

        while (bfsQ.size()!=0) {
            int qSize = bfsQ.size();
            for (int j=0; j < qSize; j++){
                String w = bfsQ.poll();
                char [] chars = w.toCharArray(); // h , i , t
                // get all neighbors and check if they are in word set
                for (int i=0; i < w.length(); i++) {
                    char original = chars [i];
                    for (char c='a'; c <='z'; c++) {
                        chars [i] = c;
                        String newWord =  new String (chars) ;
                        if (newWord.equals(endWord)){
                            ladderLength++;
                            return ladderLength;
                        }
                        else if (words.contains (newWord) && !visited.contains(newWord)) {
                            bfsQ.offer(newWord);
                            visited.add(newWord); // -- imp for bfs ... mark the visited nodes
                        }
                    }
                    chars [i] = original; // put it back
                }                
            }
            ladderLength++;
        }
        return 0;
    }
}
