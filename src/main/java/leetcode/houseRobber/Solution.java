package leetcode.houseRobber;
/*
 * 打家劫舍(即一列数组中取出一个或多个不相邻数，使其和最大)
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that 
adjacent houses have security system connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/
public class Solution {
	
	public static void main(String[] args) {
		int[] nums = new int[]{3,2,6,7};
		int rob = rob(nums);
		System.out.println(rob);
	}
	
	//思路：这是一道动态规划算法题，需要找出递推公式。
	//设f[i]表示到第i家能偷窃的最大钱数，f[0] = nums[0] (只有一家的时候当前的就是最大的了),f[1] = max(nums[0],nums[1]) (两家时取更大的数)
	//f[2]时有两种可能，就是取f[2] + f[0]或只取f[1]
	//则递推公式为f[i] = Math.max(f[i-2]+nums[i],f[i-1]);nums[i]为当前的数，f[i-2]为上上一个所能获得的最大的数和
	public static int rob(int[] nums) {
		if(nums.length == 0 || nums == null){
			return 0;
		}
		int[] f = new int[nums.length];
		
		//若数组长度为1时，则唯一的数则为最大和
		f[0] = nums[0];
		if(nums.length == 1){
			return f[0];
		}
		//若数组长度为2时，则取两数较大的数为结果
		f[1] = nums[0] > nums[1] ? nums[0] : nums[1];
		if(nums.length == 2){
			return f[1];
		}
		//i从2开始，否则i-2会造成数组越界
		for(int i = 2; i < nums.length ;i++){
			f[i] = Math.max(f[i-2] + nums[i], f[i-1]);
		}
		//因为数组索引从0开始算，所以需要减1
		return f[nums.length -1];
    }
}
