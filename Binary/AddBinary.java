// https://leetcode.com/problems/add-binary/
// T(C) - o(Max(m,n)), S(C) - o(Max(m,n))
class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        // ensure a is the longer string
        if (n < m) {
            return addBinary(b, a);
        }

        int carry = 0;
        int j = m - 1;

        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int sum = carry;

            if (a.charAt(i) == '1') {
                sum += 1;
            }

            if (j >= 0 && b.charAt(j--) == '1') {
                sum += 1;
            }

            sb.append(sum % 2);
            carry = sum / 2;            
        }

        if (carry == 1) {
            sb.append('1');
        }

        sb.reverse();
        return sb.toString();
    }
}
