package slh.bean;

public class SynClassTest {
  public synchronized void method1(){
    System.out.println("hello method1");
    try {
      wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.print("这个线程被唤醒了");
  }
  public synchronized void method2(){
    System.out.println("hello method2");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    notifyAll();
  }
  public void thread1(){
    new Thread(new Runnable() {
      public void run() {
        System.out.println("进入线程1");
        method1();
        }
    }).start();
  }
  public void thread2(){
    new Thread(new Runnable() {
      public void run() {
        System.out.println("jinruxianchenger22");
        method2();
      }
    }).start();
  }
  public static void main(String[] args){
    SynClassTest test = new SynClassTest();
    test.thread1();
    test.thread2();
  }
}
