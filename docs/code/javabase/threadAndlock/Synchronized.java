package javabase.threadAndlock;

/**
 * @author haibo.liu
 * @description
 * @date 2019/11/18
 */
public class Synchronized {
    public synchronized void test1() {
    }
    public void test2() {
        synchronized (this) {
        }
    }
}
