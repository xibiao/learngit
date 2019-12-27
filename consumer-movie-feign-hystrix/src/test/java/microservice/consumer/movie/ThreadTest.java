package microservice.consumer.movie;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        AtomicInteger integer = new AtomicInteger();
        ThreadA t1 = new ThreadA("t1");
        synchronized(t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();
                // 主线程等待t1通过notify()唤醒 或 notifyAll()唤醒，或超过3000ms延时；然后才被唤醒。
                System.out.println(Thread.currentThread().getName() + " call wait ");
                t1.wait(10);
                t1.join();
                System.out.println(Thread.currentThread().getName() + " continue");
                //t1.stop();
                t1.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class ThreadA extends Thread{
    ThreadPoolExecutor executor = new ThreadPoolExecutor(10,15,
            0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));
    Map map = new HashMap();
    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    Lock lock = new ReentrantLock();
    public ThreadA(String name) {
        super(name);
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run ");
        // 死循环，不断运行。
        while(true){
            System.out.println(System.currentTimeMillis());
        }  //  这个线程与主线程无关，无 synchronized
    }
}
