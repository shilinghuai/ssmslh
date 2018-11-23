package slh.bean;

public class TestWait {
  int ia = -1 ;
  boolean workToDo;
  public void consume(){
    System.out.println("进入消费者方法");
    new Thread(new Runnable() {
      public void run() {
        synchronized (this){
          while(!workToDo){
            try {
              this.wait();
              System.out.println("货物消费完了，消费者被阻塞了");
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            workToDo = false;
          }
          while(ia>=-20){
            ia--;
          }
        }
      }
    }).start();
  }
  public void produce(){
    System.out.println("进入生产者方法");
    new Thread(new Runnable() {
      public void run() {
        synchronized (this){
          if(!workToDo){
            workToDo = true;
          }
          try {
            Thread.sleep(3000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          this.notifyAll();
        }
      }
    }).start();
  }

  public static void main(String[] args){
    TestWait testWait = new TestWait();
    testWait.consume();
    testWait.produce();
  }
}
