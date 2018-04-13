package leetcode.validAnagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 	有效的字母异位词
Given two strings s and t, 
write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/
public class Solution {
	
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		boolean isAnagram1 = isAnagram1(s, t);
		System.out.println(isAnagram1);
		boolean isAnagram2 = isAnagram2(s,t);
		System.out.println(isAnagram2);
		
	}
	
	//思路：把s和t都拆分为一个个字符，s数组存进map并计数，遍历t并逐步减数，最终若map中计数全为0则为异位数
	//时间复杂度：O(n^3)
	public static boolean isAnagram1(String s, String t) {
		if(s.length() != t.length()){
			return false;
		}
			
		String[] strS = s.split("");
		String[] strT = t.split("");
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		for (String string : strS) {
			map.put(string, map.get(string) ==  null ? 1 : map.get(string) + 1);
		}
		for (String string : strT) {
			if(map.get(string) == null){
				return false;
			}
			map.put(string, map.get(string) - 1);
		}
		for(Map.Entry<String,Integer> entry : map.entrySet()){
			if(entry.getValue() != 0){
				return false;
			}
		}
        return true;
    }
	
	//思路：把两字符串转为字符数组后，使用数组自带函数排序，最后再比较。
	//时间复杂度：主要为排序所花费的时间O(nlogn)
	public static boolean isAnagram2(String s, String t) {
		if(s.length() != t.length()){
			return false;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		
		return Arrays.equals(str1, str2);
	}
}
