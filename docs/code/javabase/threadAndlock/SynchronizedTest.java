package javabase.threadAndlock;

/**
 * @author haibo.liu
 * @description
 * @date 2019/11/5
 */
public class SynchronizedTest {
    public synchronized void test1() {
    }
    public void test2() {
        synchronized (this) {
        }
    }
    public static synchronized void staticMethod() throws InterruptedException {
        System.out.println("静态同步方法开始");
        Thread.sleep(1000);
        System.out.println("静态同步方法结束");

    }

    public synchronized void method() throws InterruptedException {
        System.out.println("实例同步方法开始");
        Thread.sleep(1000);
        System.out.println("实例同步方法结束");
    }

    public synchronized void method2() throws InterruptedException {
        System.out.println("实例同步方法2开始");
        Thread.sleep(3000);
        System.out.println("实例同步方法2结束");
    }

    public static void main(String[] args) {
        final SynchronizedTest synDemo = new SynchronizedTest();
        Thread thread1 = new Thread(() -> {
            try {
                synDemo.method();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                synDemo.method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
}
