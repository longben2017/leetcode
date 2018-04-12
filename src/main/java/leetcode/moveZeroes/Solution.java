package leetcode.moveZeroes;

import java.util.Arrays;

/*
 * 移动0元素
 Given an array nums, write a function to move all 0's to the end of it
 while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function,
nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[]{1,0,5,0,3};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	//思路：计算0的数量，把非0元素移到前面，后面补0
    public static void moveZeroes(int[] nums) {
    	int flag = 0;
		for(int i = 0;i < nums.length;i++){
			if(nums[i] == 0){
				//当元素为0时，计数器增加
				++flag;
			}else{
				//当元素非0时，根据计数器确定位置并赋当前元素的值
				nums[i-flag] = nums[i];
			}
		}
		//根据计数器为后面的元素置为0
		for(int j = 0;j < flag;j++){
			nums[nums.length-1-j] = 0;
		}
    }
}
