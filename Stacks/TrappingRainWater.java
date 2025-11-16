// https://leetcode.com/problems/trapping-rain-water/
// T(C) - O(n), S(C) - O(n)
// Rem: Always read through code and understand what vars are passed and what is going on
class Solution {
    public int trap(int[] height) {

        int current =0;
        int ans =0;
        Deque <Integer> st = new ArrayDeque <>(); // simple que 
        int len = height.length;
        while (current < len){
            while (!st.isEmpty() && height[current] > height[st.peek()]) {
                // we need valley and we need left boundary 
                // if height[current] > top of the monotic dec stack, we have a valley
                int top = st.peek();
                st.pop(); 
                if (st.isEmpty()){
                    break;
                }

                int leftBoundary = st.peek();
                int distance = current - leftBoundary -1; 
                int h = Math.min (height[leftBoundary], height[current]) - height [top];

                ans += distance*h;
            }
            st.push(current++);
        }
        return ans;        
    }
}
