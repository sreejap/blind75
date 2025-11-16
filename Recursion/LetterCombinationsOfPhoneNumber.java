// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// T(C) - T(n) = O( n * 4ⁿ ), If the input has n digits, the total number of possible combinations is: 4ⁿ (in worst case, e.g., all digits are 7 or 9)
// S(C) - o(n)
class Solution {
    
    // correct way to init map at the class level with entries
    // string builder has length method, not size
    // string builder has deleteCharAt, not remove
    private Map<Character, String> mappings = Map.of( 
        '2',
        "abc",
        '3',
        "def",
        '4',
        "ghi",
        '5',
        "jkl",
        '6',
        "mno",
        '7',
        "pqrs",
        '8',
        "tuv",
        '9',
        "wxyz"
    );
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0){
            return new ArrayList <>();
        }

        List <String> words = new ArrayList <>();
        helper (digits,0,new StringBuilder(), words);
        return words;        
    }

    public void helper (String digits, int index, StringBuilder path, List<String> res){
        if (index == digits.length()){
            res.add(new String (path));
            return;
        }

        // get the options
        String numberMapping = mappings.get(digits.charAt(index));
        System.out.println(" char:" + digits.charAt(index) + " string " + numberMapping);
        for (char c : numberMapping.toCharArray()){
            path.append(c);
            helper (digits,index+1,path,res);
            path.deleteCharAt(path.length()-1); 
        }
    }
}
