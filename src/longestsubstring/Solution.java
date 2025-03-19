package longestsubstring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//Accepted
public class Solution {
	public static void main(String[] args) {
		
		String s = "abcabcbb";
		List<Character> resultList = new ArrayList<>();
		List<Character> resultListE = new ArrayList<>();
		int resultCount = 0;
		int result = 0;
		int end = s.length();
		int endL = s.length();
		int start = 0;
		while(start < endL) {
			resultList.add(s.charAt(start));
			resultCount ++;
			for(int j = start+ 1; j < end; j ++) {
				if(resultList.contains(s.charAt(j))) {
					break;
				}
				resultList.add(s.charAt(j));
				resultCount++;
			}
			if(resultCount > result) {
				result = resultCount;
				resultListE.clear();
				resultListE.addAll(resultList);
			}
			endL = end - result;
			start ++;
			resultList.clear();
			resultCount = 0;
		}
		System.out.println(result);
		System.out.println(resultListE);
		
	}

}
