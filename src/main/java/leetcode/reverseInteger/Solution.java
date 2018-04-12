package leetcode.reverseInteger;
/*
 * 反转数字
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only hold integers
within the 32-bit signed integer range. For the purpose of this problem, 
assume that your function returns 0 when the reversed integer overflows. 
*/
public class Solution {
	public static void main(String[] args) {
		int x = -1312;
		int reverseNum = reverse(x);
		System.out.println(reverseNum);
	}
	
	//思路：循环取int值的个位数，每次循环都用上一次的结果乘10再加上新数的个位数。
	//注意反转途中的数值溢出问题
    public static int reverse(int x) {
        long result = 0;
         while(x != 0){
             result = (result * 10) + x % 10;
             if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                 return 0;
             }
             x /= 10;
         }
         return (int)result;
     }
}
