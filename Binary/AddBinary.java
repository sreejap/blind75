// https://leetcode.com/problems/add-binary/
// T(C) - o(Max(m,n)), S(C) - o(Max(m,n))
class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (n < m) {
            return addBinary (b,a);


        }

        int carry =0;
        int sum = 0;
        int j = m-1;

        StringBuilder sb = new StringBuilder ();
        for (int i=n-1; i > -1; i--){
            if (a.charAt(i)=='1'){
                carry++;
            }

            if (j >-1 && b.charAt(j--)=='1'){
                carry++;
            }

            if (carry %2==0){
                sb.append('0');
            } else { // make sure we handle both cases...
                sb.append ('1');
            }

            carry =carry/2;
            

        }

        if (carry == 1){
            sb.append ('1');
        }

        sb.reverse();
        return sb.toString();
        
    }
}
