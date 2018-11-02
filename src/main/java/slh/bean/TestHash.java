package slh.bean;

import java.util.HashMap;

public class TestHash {
  int ia;

  public TestHash(int ia) {
    this.ia = ia;
  }
  Object j= null;
  @Override
  public int hashCode() {
    return ia;
  }

  @Override
  public boolean equals(Object obj) {
    return this.ia==((TestHash)obj).ia;
  }
  public static void main(String[] args){
    HashMap<TestHash,String> hashMap = new HashMap<TestHash,String>();
    TestHash testHash = new TestHash(1);
    hashMap.put(testHash,"hello");
    TestHash testHash1 = new TestHash(1);
    System.out.println(hashMap.get(testHash1));
  }
}
