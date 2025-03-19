package minium_operations;
//accepted
//https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,1,1,1};
        System.out.println(minOperations(nums));

    }
    public static int minOperations(int[] nums) {
        int index = 0;
        int rs = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                rs ++;
            }
        }
        if(nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0){
            return -1;
        }
        return rs;
    }



}
