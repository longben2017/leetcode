package leetcode.powerOfThree;
/*
 * 3的次方
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion? 
*/
public class Solution {
	
	public static void main(String[] args) {
		int n = 9;
		boolean isPowerOfThree = isPowerOfThree1(n);
		System.out.println(isPowerOfThree);
		boolean isPowerOfThree2 = isPowerOfThree2(n);
		System.out.println(isPowerOfThree2);
	}
	
	//思路：不停地除以3，看最后的余数是否为1
	public static boolean isPowerOfThree1(int n) {
		//排除非正整数
        if(n < 1){
            return false;   
        }
        //对3取余为0的情况下不断除以3
        while(n % 3 == 0){
            n /= 3;   
        }
        return n == 1;
	}
	
	//思路：输入的为int，正数范围为(0，2^31],在此范围允许的最大3的次方数为3^19=1162261467
	//此时只要确定此数能被n整除即可
	public static boolean isPowerOfThree2(int n){
		return (n > 0 && 1162261467 % n == 0);
	}
}
