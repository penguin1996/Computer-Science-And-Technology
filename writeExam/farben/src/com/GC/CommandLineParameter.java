package src.com.GC;

import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class CommandLineParameter {

    public static void main(String[] args) {
        System.out.println(args);
        for (String s:args) {
            System.out.println(s);
        }

        Object object = null;
        ArrayList arrayList = new ArrayList();
        arrayList.add(object);
        int i = arrayList.indexOf(arrayList.get(0));
        System.out.println(arrayList.toString());
        System.out.println(i);

        ReentrantLock reentrantLock;

        ThreadPoolExecutor threadPoolExecutor;
        Executors executors;
        ExecutorService executorService;
    }
}
