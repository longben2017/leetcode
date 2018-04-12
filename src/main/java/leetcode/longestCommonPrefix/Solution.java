package leetcode.longestCommonPrefix;
/*
 * 最长公共前缀
 Write a function to find the longest common prefix string amongst an array of strings. */
public class Solution {
	//思路：首先以第一个元素为基准遍历字符串数组，与第一个元素对比，取更短的元素。
	//比较两元素每一个字符，当出现不同则当前位置前则为最短前缀。
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1;i < strs.length;i++){
            int len = prefix.length() > strs[i].length() ? strs[i].length() : prefix.length();
            int j;
            for(j = 0;j < len;j++){
                if(prefix.charAt(j) != strs[i].charAt(j)){
                    break;   
                }
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
}
