package leetcode.numberOf1Bits;
/*	
 * 	位1的个数
Write a function that takes an unsigned integer 
and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
so the function should return 3.

// you need to treat n as an unsigned value
*/
public class Solution {
	
	public static void main(String[] args) {
		int n = 4;
		int hammingWeight = hammingWeight(n);
		System.out.println(hammingWeight);
		
		int hammingWeight2 = hammingWeight2(n);
		System.out.println(hammingWeight2);
	}
	
	//&的用法，把左右两边的数先转化为二进制，对应的数为1结果才为1，否则为0
	//思路：设n=110101
	//           n               n-1           n&(n-1)
	//step1:   110101          110100          110100
	//step2:   110100          110011          110000
	//step3:   110000          101111          100000
	//step4:   100000          011111          000000
	//发现有几个1，就循环几次n&(n-1)得到0
    public static int hammingWeight(int n) {
    	int result = 0;
    	while(n != 0){
    		n &= n-1;
    		result++;
    	}
        return result;
    }
    
    //思路：每次使n与1做&运算，当二进制的n的最后一位为1时，运算结果为true，则计数加1。每次运算后使n右移一位，直到n==0为止
    //此算法比上一算法步数要更多，因为要把二进制中等于0的也比较
    public static int hammingWeight2(int n){
    	int result = 0;
    	while(n != 0){
    		if((n & 1) >0 ){
    			++result;
    		}
    		n >>= 1;
    	}
    	return result; 
    }
}
