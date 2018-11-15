package slh.bean;

import java.util.HashMap;

public class Test {
  private String test;
  class Student{
    int age;
    String name;

    public Student(int age, String name) {
      this.age = age;
      this.name = name;
    }
  }
  public String getTest() {
    return test;
  }

  public void setTest(String test) {
    this.test = test;
  }
  Student change(Student s){
    int ia = 1;
    for(int ib = 0;ib<10;ib++){
      ia = 3;
    }
    Student studentTmp = s;
    s = new Student(1,"LISI");
    return s;
  }
  public static void main(String[] args){
    Test test = new Test();
    Test.Student s = test.new Student(11,"libai");
    System.out.println(test.change(s).age+"---");
    int[] ia = new int[2];
    HashMap<String,String> m = new HashMap<String, String>();
    int i = 1;
  }

}
