package leetcode.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers 
such that they add up to a specific target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

public class Solution {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
		int[] twoSum = twoSum(nums, target);
		System.out.println(Arrays.toString(twoSum));
	}
	
	//思路：使用map，元素的值为key，元素的索引为value
	public static int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	    	//查看map中是否存在目标值减去当前循环元素值的值，若存在则说明已找到所需的两元素，返回索引即可。
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i ;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i);
	    }
	    return result;
	}
}
