// https://leetcode.com/problems/evaluate-reverse-polish-notation/
// T(C) - O(n), S(C) - o(n)
// imp: be careful with variable names
class Solution {
    public int evalRPN(String[] tokens) {
        Stack <Integer> st = new Stack <>();
        Set <String> operators = new HashSet <>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for (String s : tokens) {
            if (!operators.contains(s)){ // set has + - * /
                st.push(Integer.parseInt(s));
            }
            else {
                int a1=0;
                int a2 = 0;
                if (st.size()!=0) {
                    a1 = st.pop();
                }

                if (st.size()!=0){
                    a2 = st.pop();
                }

              //  System.out.println("a1: " + a1 + "  a2: " + a2);
                if (s.equals("+")) {
                    st.push (a2+a1);
                    System.out.println (st.peek());
                }

                else if (s.equals ("-") ){
                    st.push(a2-a1);
                }

                else if (s.equals("*")){
                    st.push (a2*a1);
                }

                else {
                    st.push (a2/a1);
                }
            }
        }

        int ans = 0;
        if (st.size()!=0) {
            ans = st.pop();
        }
        return ans;
    }

}
