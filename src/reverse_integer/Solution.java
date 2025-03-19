package reverse_integer;

//https://leetcode.com/problems/reverse-integer/submissions/1230054736/
//Accepted a 
public class Solution {
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
		
	}
	public static int reverse(int x) {
		
		boolean isNegative = false;
		if(x < 0 ) {
			x = x * -1;
			isNegative = true;
		}
		int rs = 0;
		while(x > 0) {
			int temp = rs;
			rs = rs*10 + x % 10;
			if((rs - x % 10)/10  != temp) {
				return 0;
			}
			x=x/10;
			
		}
		if(isNegative) {
			rs = rs * -1;
		}
		
		return rs;
    }

}
