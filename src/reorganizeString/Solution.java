package reorganizeString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
//Accepted
//https://leetcode.com/problems/reorganize-string/
public class Solution {
	public static String reorganizeString(String s) {
		HashMap<Character, Integer> map = getMaxOccurringChar(s);
		LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		// sort list
		for (Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer str, Integer str1) {
                return (str).compareTo(str1);
            }
        });
        Collections.reverse(list);
        for (Integer str : list) {
            for (Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == (str)) {
                    sortedMap.put(entry.getKey(), str);
                }
            }
        }
        
         s = "";
        for (Entry<Character, Integer> entry : sortedMap.entrySet()) {
           for(int i = 0; i < entry.getValue(); i ++) {
        	   s += entry.getKey();
           }
        }

		
		if(s.length() < 1) return s;
		
		// swap if double
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				boolean isSwap = false;
				for (int j = i; j < s.length(); j++) {
					if (s.charAt(j) != s.charAt(i)) {
						s = swap(s, i, j);
						isSwap = true;
						
						break;

					}
				}
				
				if(!isSwap) {
					for (int j = i; j > 0; j--) {
						if (s.charAt(j) != s.charAt(i)  && s.charAt(j - 1) != s.charAt(i)) {
							s = swap(s, i, j);
							isSwap = true;
							i = j ;
							
							break;

						}
						
					}
					
				}
				if(!isSwap) {
					
					return "";
				}
			}
		}
		return s;
	}
	static HashMap<Character, Integer>  getMaxOccurringChar(String str) {
        
        // create HashMap to store frequency of every character
        HashMap<Character, Integer> mp = new HashMap<>();
         
        // to store length of string
        int n = str.length();

        // traverse the string
        for(int i = 0; i < n; i++) {
            // push element into map and increase its frequency 
            char c = str.charAt(i);
            if(mp.containsKey(c)) {
            	mp.put(c, mp.get(c) + 1);
            }
            else{
            	mp.put(c, 1);
            }
             
           
            
        }
         
        return mp;
    }

	static String swap(String str, int i, int j) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(i, str.charAt(j));
		sb.setCharAt(j, str.charAt(i));
		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(reorganizeString("aaab"));
	}
}
