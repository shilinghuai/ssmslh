package slh.bean;

import java.util.concurrent.ConcurrentHashMap;

public class TestWait {
  static Object o = new Object();
  boolean workToDo = true;
  public void consume(){
    System.out.println("进入消费者方法");
    new Thread(new Runnable() {
      public void run() {
        synchronized (o){
          System.out.println(this);
          while(workToDo){
            try {
              o.wait();
              System.out.println("货物消费完了，消费者被阻塞了");
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }).start();
  }
  public void produce(){
    System.out.println("进入生产者方法");
    new Thread(new Runnable() {
      public void run() {
        synchronized (o){
          System.out.println(this);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          o.notifyAll();
        }
      }
    }).start();
  }

  public static void main(String[] args){
    ConcurrentHashMap map = new ConcurrentHashMap();
    map.put("xx","sss");
    TestWait testWait = new TestWait();
    testWait.consume();
    testWait.produce();
  }
}
