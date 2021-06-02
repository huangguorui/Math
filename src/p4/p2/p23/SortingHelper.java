package p4.p2.p23;



public class SortingHelper {
    private SortingHelper(){}

    /**
     *
     * @param arr
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i = 1; i < arr.length; i++)
            //判断排序是否是正确的
            if(arr[i-1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }
    /**
     *
     */
    public static  <E extends Comparable<E>> void  sortTest(String sortname ,E[] arr){


        long startTime = System.nanoTime();
        if(sortname.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if(sortname.equals("InsertionSort"))
            InsertionSort.sort(arr);
        else if(sortname.equals("MergeSort"))
            MergeSort.sort(arr);
        else if(sortname.equals("MergeSort2"))
            MergeSort.sort2(arr);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname + " failed");
//        System.out.println(time + " s");
        System.out.println(String.format("%s , n = %d : %f s", sortname , arr.length,time));

    }


}
