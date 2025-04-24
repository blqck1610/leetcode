package zigzag_conversion;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

//link: https://leetcode.com/problems/zigzag-conversion/description/
// accepted, 5ms
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = solution.convert(s, numRows);
        System.out.println(result); // Output: "PAHNAPLSIIGYIR"
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) {
            return s;
        }
        int up = 1;
        int index = 0;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        for(int i = 0; i < s.length(); i ++){
            if(index < 0 || index >= numRows){
                up = up * -1;
                index += up;
                i --;
            }
            else
                rows.get(index).append(s.charAt(i));
            index += up;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}

