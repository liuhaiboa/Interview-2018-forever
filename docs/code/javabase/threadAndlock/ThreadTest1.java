package javabase.threadAndlock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haibo.liu
 * @date 2019/11/18
 */
public class ThreadTest1 extends Thread {
    private Object object;
    public ThreadTest1(Object object) {
        this.object = object;
    }
    public void run() {
        synchronized (object) {
            System.out.println("刘哈哈拿到锁啦");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("5s后。。。。");
            System.out.println("刘哈哈释放锁啦");
        }
    }
    public static void main(String args[]) {
        Object object = new Object();
        Object object1=new Object();
        ThreadTest1 threadTest1 = new ThreadTest1(object);
        ThreadTest2 threadTest2 = new ThreadTest2(object1);
        threadTest1.start();
        threadTest2.start();
    }
}
class ThreadTest2 extends Thread {
    private Object object;
    public ThreadTest2(Object object){
        this.object=object;
    }
    @Override
    public void run(){
        System.out.println("二哈等锁中。。。。");
        synchronized (object){
            System.out.println("二哈拿到锁啦");
        }

    }
}

class ThreadTest3 implements Runnable {
    private String name;
    private static MethodSync methodSync = new MethodSync();
   // private MethodSync methodSync = new MethodSync();
    public ThreadTest3(String name) { this.name = name; }
    @Override
    public void run() {
        methodSync.method(name);
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadTest3("test 1"));
        Thread t2 = new Thread(new ThreadTest3("test 2"));
        t1.start();
        t2.start();
    }
}
class MethodSync {
    public static synchronized void method(String name){
        System.out.println(name + " Start a sync method");
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){}
        System.out.println("3s后");
        System.out.println(name + " End the sync method");
    }
}

