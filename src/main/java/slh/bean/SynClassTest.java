package slh.bean;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class SynClassTest {
  public synchronized void method1(){
    ConcurrentHashMap map = new ConcurrentHashMap();
    HashMap hashMap = new HashMap();
    int x = 0;
    int y;
    y = x++ + x++;
    System.out.println(y);
    System.out.println("hello method1");
    System.out.println("hello method1");
    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
  public synchronized void method2(){
    System.out.println("hello world 2");
    System.out.println("hello method1");

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
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
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
    int ia = 1;
    ia++;

  }
}
