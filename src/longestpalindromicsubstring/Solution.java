package longestpalindromicsubstring;

import java.util.HashMap;

//https://leetcode.com/problems/longest-palindromic-substring/description/
//accept

public class Solution {
	
	public static void main(String[] args) {
		String input = "ac";
		System.out.println(longestPalindrome(input));

	}
	
	public static String longestPalindrome(String s) {
		if(s.length() == 1) {
			return s;
		}
		String rs = s.charAt(0) + "";
		int min = 1;
		int index = 0; 
		int end = s.length();
		while(index < end) {
			String subString = "" + s.charAt(index);
			int endi = s.length();
			for(int i = s.length() - 1; i > index; i--) {
				if(s.charAt(i) == subString.charAt(0)) break;
				
				endi --;
			}
			
			for(int i = index + 1; i < endi; i++) {
				
				subString += s.charAt(i);
				if(subString.charAt(i - index) != s.charAt(endi - (i - index) - 1)) {
					endi--;
				}
				if(isPalindrome(subString) && subString.length() >= min) {
					rs = subString;
					min = subString.length();
				}
			}
			end = s.length() - min;
			index++;
		}
		
		return rs;
	
	}
	public static Boolean isPalindrome(String s) {
		
		String s2 = new StringBuilder(s).reverse().toString();
		
		if(s.toString().equals(s2)){
			return true;
		}
		return false;
		
		
	}
}
