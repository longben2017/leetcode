package leetcode.containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*存在重复数
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
*/
public class Solution {
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,5,5};
		boolean containsDuplicate1 = containsDuplicate1(nums);
		System.out.println(containsDuplicate1);
		boolean containsDuplicate2 = containsDuplicate2(nums);
		System.out.println(containsDuplicate2);
	}
	
	//思路：用Set集合元素的唯一性解决，时间复杂度为O(n).
    public static boolean containsDuplicate1(int[] nums) {
    	Set<Integer> set = new HashSet<Integer>();
    	for (Integer num : nums) {
			if(set.contains(num)){
				return true; 
			}else{
				set.add(num);
			}
		}
        return false;
    }
    
    //思路：对整数数组排序并遍历，若有相同元素，则肯定存在当前元素与下一元素值相同的情况，遍历时需注意数处越界问题
    //时间复杂度为O(nlogn)
    public static boolean containsDuplicate2(int[] nums) {
    	Arrays.sort(nums);
    	for(int i = 0 ;i < nums.length -1 ; i++){
    		if(nums[i] == nums[i+1]){
    			return true;
    		}
    	}
    	return false;
    }
}
