package util;

import slh.bean.BTree;

public class MyStack<T> {
  T[] data;
  int top = -1;
  public MyStack(T[] data) {
    this.data = data;
  }
  public void push(T t){
    data[++top] = t;
  }
  public T pop(){
    if(top == -1){
      return null;
    }
    return data[top--];
  }
  public static void main(String[] args){
    MyStack<BTree> myStack = new MyStack<BTree>(new BTree[100]);
    myStack.push(new BTree(new int[]{1,2,3}));
    myStack.push(new BTree(new int[]{2,2,3}));
    myStack.push(new BTree(new int[]{3,2,3}));
  }
}
