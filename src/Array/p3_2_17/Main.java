package Array.p3_2_17;

public class Main {
    public static void main(String[] args) {
        //泛型不可存放基本数据类型
//        Array123<Integer> arr = new Array123<Integer>(20);
        //java1.7之后new Array123<Integer>中的Integer可以省略
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        //打印输出
        System.out.println(arr);

        //测试插入
        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        //{-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9}

        arr.remove(2);
        System.out.println(arr);
        //{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}

        arr.removeElement(4);
        System.out.println(arr);
        //{-1, 0, 1, 2, 3, 5, 6, 7, 8, 9}

        arr.removeFirst();
        System.out.println(arr);
        //{0, 1, 2, 3, 5, 6, 7, 8, 9}


    }
}
