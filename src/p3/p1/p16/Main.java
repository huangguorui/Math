package p3.p1.p16;


import java.util.Random;

public class Main {
    //测试使用stack运行opCount个push和pop操作所需要的时间 ，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();
        //...
        Random random = new Random();
        for (int i = 0;i < opCount; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;
    }
    public static void main(String[] args) {

        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double tiem1 = testStack(arrayStack,opCount);
        System.out.println("ArrayStack, time:" + tiem1 + " s");;

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double tiem2 = testStack(linkedListStack,opCount);
        System.out.println("LinkedListStack, time:" + tiem2 + " s");;

        //其实这个时间比较很复杂，因为LinkedListStack中包含更多的new操作
    }
}
