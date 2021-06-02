package p4.p2.p28;
//https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/comments/
class Solution {
    public int reversePairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if(nums[i] > nums[j]) res ++;
        return res;
    }
}