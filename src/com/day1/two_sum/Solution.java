package com.day1.two_sum;

// https://leetcode.com/problems/two-sum/
//Accepted
public class Solution {
	public static void main(String[] args) {
		
	}
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
			
		}
		
		return result;
        
    }
}
