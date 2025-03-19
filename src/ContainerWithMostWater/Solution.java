package ContainerWithMostWater;

//https://leetcode.com/problems/container-with-most-water/description/
// accept 
public class Solution {
	public static void main(String[] args) {
		int[] input = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(input));

	}

	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int rs = 0;
		while(left < right) {
			int area = (height[left] > height[right] ? height[right] : height[left]) * (right - left);
			rs = area > rs ? area : rs;
			if(height[left] > height[right]) {
				right --;
			}
			else {
				left++;
			}
			
		}
		
		
		return rs;
	}
}
// accept
//int max = 0;
//int left = 0;
//int right = height.length - 1;
//
//for(int i = 0; i < height.length; i++){
//    // int min = 0;
//    // left = i;
//    // right = height.length - i - 1;
//    int preMax = Math.min(height[left], height[right]) * (right - left);
//    max = max > preMax ? max : preMax;
//    if(height[left] < height[right]){
//        left++;
//    }else {
//        right--;
//    }
//}
//return max;

//	public static int maxArea(int[] height) {
//		
//		
////		time limit Exceeded 
//		int rs = 0;
//		for(int i = 0 ;i < height.length; i ++) {
//			for(int j = i; j < height.length; j++) {
//				int width = j - i;
//				int are = (height[i] >= height[j] ? height[j] : height[i]) * width;
//				if(are > rs) {
//					rs = are;
//				}
//			}
//		}
//		
//		
//		return rs;
//	}
//}
