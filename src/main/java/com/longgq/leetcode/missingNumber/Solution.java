package com.longgq.leetcode.missingNumber;

import java.util.Arrays;

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.

Example 1

Input: [3,0,1]
Output: 2

Example 2

Input: [9,6,4,2,3,5,7,0,1]
Output: 8


Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?
*/

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[]{3,0,1};
		int missingNumber = missingNumber(nums);
		System.out.println(missingNumber);
		
		int missingNumber2 = missingNumber2(nums);
		System.out.println(missingNumber2);
	}
	
	
	//思路：考虑到将原数组排序后，如果不缺失元素，数组下标值和元素值是相等的；若不等，则下标值为所求的数
	public static int missingNumber(int[] nums) {
		Arrays.sort(nums);
	    
	    for (int i = 0; i < nums.length; i++) {
	        if (nums[i] != i) {
	            return i;
	        }
	    }
	    
	    return nums.length;
	}
	
	//思路：对给定数组和不缺失情况下的数组进行异或连接操作，最终能得到缺失的数字
	public static int missingNumber2(int[] nums){
		int missingNumber = nums.length;
		for(int i = 0;i < nums.length;i++){
			missingNumber ^= nums[i] ^ i; 
		}
		return missingNumber;
	}
}
