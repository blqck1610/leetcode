package stringtointeger;

//https://leetcode.com/problems/string-to-integer-atoi/
//accept
public class Solution {
	public static void main(String[] args) {
		String input = " ";
		System.out.println(myAtoi(input));

	}

	public static int myAtoi(String s) {
		if(s.length() == 0) {
			return 0;
		}
		int index = 0;
		String rsS = "";
		
		boolean isNegative = false;
		while(index < s.length() && s.charAt(index) == ' '  ) {
			index ++;
		}
		if(index < s.length()) {
			if(s.charAt(index) == '-') {
				isNegative = true;
				index ++;
			}
			else if(s.charAt(index) == '+'){
				index ++;
			}
		}
		while(index < s.length() &&s.charAt(index) == '0'  ) {
			index ++;
		}
		
		for( ;index < s.length(); index++) {
			if( s.charAt(index) >= '0' && s.charAt(index) <= '9') {
				rsS += s.charAt(index) + "";
			}
			else {
				break;
				
			}	
				
		}
		
		try{
			if(!rsS.equals("")) {
				if(isNegative) {
					return Integer.parseInt(rsS) * -1;
					
				}
				else {
					return Integer.parseInt(rsS);
				}
			}
           

        }
        catch(NumberFormatException e){
            return (isNegative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
		return 0;

	}
	

}
