import java.util.*;
/*
*此题只要使用dfs深度搜索，利用回溯进行解答这题
*在进行优化可以进行剪枝处理
*例如在res.size() >= 2 且 第三个数比前面两个数大时，没有进行比较，可以直接break;
*/
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res,S,0);
        return res;
    }
    public boolean dfs(List<Integer> res,String s , int start){
        if(start >= s.length() && res.size()>=3){
            return true;
        }
        for(int i=start;i<s.length();i++){
            if(s.charAt(start) == '0' && i>start){
                break;
            }
            long num = Long.valueOf(s.substring(start,i+1));
            if(num > Integer.MAX_VALUE){
                break;
            }
            if(res.size()<=1 || num == (res.get(res.size()-1) + res.get(res.size()-2))){
                res.add((int)num);
                if(dfs(res,s,i+1)){
                    return true;
                }
                res.remove(res.size()-1);
            }
        }
        return false;
    }
}