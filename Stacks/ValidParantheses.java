class Solution {
    public boolean isValid(String s) {
        // make sure to validate corner cases like "]"
        // take care of null pointers , check if stack is empty 
     ArrayDeque <Character> st = new ArrayDeque <>();

     Map <Character,Character> mapping = new HashMap <>();
     mapping.put('(',')');
     mapping.put('{','}');
     mapping.put('[',']');

     for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            st.push (c);
        }else {
            if ( !st.isEmpty () && c != mapping.get(st.peek()) ) { // take care of null pointers , check if stack is empty 
                return false;
            }else {
                if (!st.isEmpty())
                    st.pop(); // take care of null pointers , check if stack is empty 
                else {
                    return false;
                }
            }
        }
     }

     return st.isEmpty ();
    }
}
