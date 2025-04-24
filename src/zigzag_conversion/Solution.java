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
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        int up = -1;
        int currentRow = 0;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                up *= -1;
            }
            currentRow += up;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}

