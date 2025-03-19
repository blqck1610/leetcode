package LongestCommonPrefix;
//accepted
//https://leetcode.com/problems/longest-common-prefix/description/
public class Solution {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        if (strs.length < 1 || strs[0].isEmpty()) return "";
        int index = -1;
        for (int i = 0; i < Math.min(strs[0].length(), strs[1].length()); i++) {
            if (strs[0].charAt(i) == strs[1].charAt(i)) {
                index = i;
            } else break;
        }
        if (index < 0) {
            return "";
        }
        if (strs.length > 2) {
            for (int i = 2; i < strs.length; i++) {
                if (index >= strs[i].length()) {
                    index = strs[i].length() - 1;
                }
                for (int j = index; j >= 0; j--) {
                    if (strs[i].charAt(j) != strs[0].charAt(j)) {
                        index = j - 1;
                    }
                }
                if (index < 0) {
                    break;
                }
            }
        }
        return index < 0 ? "" : strs[0].substring(0, index + 1);
    }
}
