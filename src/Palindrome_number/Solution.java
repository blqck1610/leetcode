package Palindrome_number;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-number/description/
//Accepted
public class Solution {
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		
	}
	public static boolean isPalindrome(int x) {
		if(x < 0 ) return false;
		if(x == 0) return true;
		
		int a = x;
		int y = 0;
		while(a > 0) {
			y = y * 10 + a % 10;
			a = a / 10;
		}
		
		return x == y;
    }
}
