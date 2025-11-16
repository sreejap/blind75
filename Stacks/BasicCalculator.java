// https://leetcode.com/problems/basic-calculator/
// T(C) - o(n), S(C) - o(n)
class Solution {
    public int calculate(String s) {
        int number = 0;
        int sign = 1;
        int res = 0;
        Stack <Integer> st = new Stack <>();
        for (int i=0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (Character.isDigit(ch)){
                number = number * 10 + (ch - '0');

            }else if (ch =='+'){
                res += sign * number;
                number = 0;
                sign = 1;
            }else if ( ch == '-'){
                res += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '('){
                st.push(res);
                st.push (sign);
                res = 0;
                sign = 1;
            } else if ( ch == ')') {
                // write down different cases ..
                res += sign * number;
                number =0;
                res *= st.pop();
                res += st.pop();
            }
        }

        if (number !=0){
            res += sign * number;
        }
        return res;        
    }
}
