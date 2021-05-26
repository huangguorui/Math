package Stack.p3_2_27;


import Stack.p3_2_25.Queue.Queue;

import java.util.Random;

public class Main {
    //测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();
        //...
        Random random = new Random();
        for (int i = 0;i < opCount; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;
    }
    public static void main(String[] args) {

        int opCount = 100000;
        //ArrayQueue是系统自带的 com.sun.jmx.remote.internal.ArrayQueue
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double tiem1 = testQueue( arrayQueue,opCount);
        System.out.println("ArrayQueue, time:" + tiem1 + " s");;

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double tiem2 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue, time:" + tiem2 + " s");;

    }
}
