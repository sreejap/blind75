/*
* Convert a and b into integers x and y, x will be used to keep an answer, and y for the carry.

* While carry is nonzero: y != 0:

*  Current answer without carry is XOR of x and y: answer = x^y.

*  Current carry is left-shifted AND of x and y: carry = (x & y) << 1.

*  Job is done, prepare the next loop: x = answer, y = carry.

*  Return x in the binary form.
*/
import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
}
