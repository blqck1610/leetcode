package medianof2array;

import java.util.Collection;

//https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/1250402761/
// accept
// hard
public class Solution {

	public static void main(String[] args) {
		int[] num1 = {1, 3, 5 , 7 ,11, 19};
		int[] num2 = {2, 6, 9};
		System.out.println(findMedianSortedArrays(num1, num2));
		
		
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
 		
		int[] nums = new int[nums1.length + nums2.length];
		int i = 0;
		int j = 0;
		int index = 0;
//		merge 2 arrays to sorted array
		while(i < nums1.length && j < nums2.length) {
			if(nums1[i] <= nums2[j]) {
				nums[index] = nums1[i];
				index ++;
				i++;
			}
			else {
				nums[index] = nums2[j];
				index ++;
				j ++;
			}
		}
		if(i >= nums1.length && j < nums2.length) {
			for(; index < nums.length; index ++) {
				nums[index] = nums2[j];
				j ++;
			}
		}
		else if(i < nums1.length && j >= nums2.length) {
			for(; index < nums.length; index ++) {
				nums[index] = nums1[i];
				i ++;
			}
		}
//		find medina 
        
 		if(nums.length % 2 == 0) {
 			return (1.0 * nums[(nums.length / 2) - 1] + nums[(nums.length / 2) ]) / 2;
 		}
 		else {
			return nums[((nums.length + 1) / 2) - 1];
		}
		
		
    }
	
}
