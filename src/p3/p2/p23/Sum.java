package p3.p2.p23;

public class Sum {

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    //计算arr[l...n)这个区间内所有数字的和
    private static int sum(int[] arr,int l){
        if(l == arr.length)
            return 0;
        return arr[l] +sum(arr,l + 1);
    }
    //l 依次递归
    //依次执行递归并返回结果，最后执行打印语句，返回结果36
    //0  return arr[0] +sum(arr,1); //1+(35)
    //1  return arr[1] +sum(arr,2); //2+(32)
    //2  return arr[2] +sum(arr,3); //3+(29)
    //3  return arr[3] +sum(arr,4); //4+(25)
    //4  return arr[4] +sum(arr,5); //5+(21)
    //5  return arr[5] +sum(arr,6); //6+(15)
    //6  return arr[6] +sum(arr,7); //7+8
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(sum(nums));
    }

}
