package javabase.threadAndlock;


/**
 * @author haibo.liu
 * @description
 * @date 2019/11/18
 */
public class SynchronizedLockTest {
    public synchronized void gc() {
        gcc();
    }

    private synchronized void gcc() {
        System.out.println("li gang come on");

    }



    public static void main(String[] args) {
        new SynchronizedLockTest().gc();
    }


}
