package leetcode.palindromeNumber;
/*
 * 回文数
 Determine whether an integer is a palindrome. 
 Do this without extra space.
 */
public class Solution {
	
	public static void main(String[] args) {
		int x = 123321;
		boolean palindrome = isPalindrome(x);
		System.out.println(palindrome);
	}
	//思路：1、先排除负数和尾数为0的数
	//     2、取一个数的后一半，看是否与前一半相同。
	//	   3、若该数位数为奇数，则后一半的数字除10再与前一半比较
    public static boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 ==0 )){
            return false;
        }
        int rev = 0;
        while(x > rev){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev /10;
    }
}
