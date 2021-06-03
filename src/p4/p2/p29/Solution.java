package p4.p2.p29;

import p4.p2.p25.InsertionSort;

//https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/comments/
class Solution {

    private int res = 0;

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];

        res = 0;
        sort(nums,0,nums.length - 1,temp);
        return res;
    }

    private void sort(int[] arr, int l, int r,int[] temp) {
        if (l >= r) return;
        //可能产生bug的问题，整型溢出,数组越界
        //int mid = (l + r) / 2;
        //解决方法
        int mid = l + (r -l) / 2;

        sort(arr, l, mid,temp);
        sort(arr, mid + 1, r,temp);
        if(arr[mid] > arr[mid + 1])
            merge(arr, l, mid, r,temp);
    }

    //合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
    public void merge(int[] arr, int l, int mid, int r,int[] temp) {

        System.arraycopy(arr,l,temp,l,r - l + 1);

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                res +=mid -i +1;
                arr[k] = temp[j];
                j++;
            }

        }
        //arr[i] 和 arr[j]


    }

}