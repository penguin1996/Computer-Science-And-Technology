package src.Test.accumulator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

public class AccumulatorTest {
    /*
    * (x,y)->x+y Lambda表达式
    * Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器会通过上下文推断出来，数据类型，即“类型推断”
    * 将表达式中的x作为初始值，然后将y作为算数值
    * 第一步将identity=0赋值给x
    * 第二步将算式的结果赋值给y即y =（x + y）
    * 第三步将1赋值给x，然后执行y = 1 + 0 = 1
    * 数学归纳法
    * */
    public static void main(String[] args) {
        //初始化
        LongAccumulator accumulator = new LongAccumulator((x,y)->x+y,0);
        //为x重新赋值
        accumulator.accumulate(1);
        System.out.println("1+0的最终结果为："+accumulator.getThenReset());
        //利用线程池
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        //range(1,10) 等价 [1,10) 等价 [1,9]
        IntStream.range(1,10).forEach(i->executorService.submit(()->accumulator.accumulate(i)));
        //等待线程池中所有的线程执行完
        executorService.shutdown();
        //判断线程池中所有的线程是否执行完
        while (!executorService.isTerminated()){

        }
        System.out.println("1~9累加的最终结果为："+accumulator.getThenReset());
    }
}
