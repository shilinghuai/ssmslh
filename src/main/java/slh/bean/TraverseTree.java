package slh.bean;

import sun.reflect.generics.tree.Tree;

public class TraverseTree {
  static class TreeNode{
    int data;
    TreeNode lTreeNode;
    TreeNode rTreeNode;

    public TreeNode(int data, TreeNode lTreeNode, TreeNode rTreeNode) {
      this.data = data;
      this.lTreeNode = lTreeNode;
      this.rTreeNode = rTreeNode;
    }
  }
  static TreeNode treeNode1 = new TreeNode(1,null,null);
  static TreeNode treeNode2 = new TreeNode(2,null,null);
  static TreeNode treeNode3 = new TreeNode(3,null,null);
  static TreeNode treeNode4 = new TreeNode(4,null,null);
  static TreeNode treeNode5 = new TreeNode(5,null,treeNode1);
  static TreeNode treeNode6 = new TreeNode(6,treeNode3,treeNode2);
  static TreeNode treeNode7 = new TreeNode(7,treeNode5,treeNode4);
  static TreeNode treeNode8 = new TreeNode(8,treeNode7,treeNode6);
  static class MyStack{
    static TreeNode[] treeNode = new TreeNode[100];
    static int top = -1;
  }
  static void push(TreeNode treeNode){
    MyStack.treeNode[++MyStack.top]=treeNode;
  }
  static TreeNode pop(){
    return MyStack.treeNode[MyStack.top--];
  }
  static TreeNode getTop(){
    return MyStack.treeNode[MyStack.top];
  }
  static int[] ia = new int[100];
  static int ib = 0;
  static void putIA(int x){
    ia[ib++] = x;
  }
  static boolean isINIA(int x){
    boolean flag = false;
    for(int ic = 0;ic<ia.length;ic++){
      if(x==ia[ic]){
        flag = true;
      }
    }
    return flag;
  }
  //先序遍历，递归
  //先访问树的根，再先序遍历树的左字数，再先序遍历树的右子树
  static void traverseTree(TreeNode treeNode){
    if(treeNode!=null){
      System.out.println(treeNode.data);
      traverseTree(treeNode.lTreeNode);
      traverseTree(treeNode.rTreeNode);
    }
  }
  static void notRecursionMiddle(TreeNode treeNode){
    //沿着节点的左子树方向深入，如果是null，出栈，出栈的时候访问,再顺着其右子树继续如此深入。
    while(treeNode!=null||MyStack.top!=-1){
      while (treeNode!=null){
        push(treeNode);
        treeNode = treeNode.lTreeNode;
      }
      TreeNode treeNode9 = pop();
      System.out.println(treeNode9.data);
      treeNode = treeNode9.rTreeNode;
    }
  }
  static void notRecursionFrist(TreeNode treeNode){
    //沿着节点的左子树方向深入，深入的时候访问，如果是null，出栈,再顺着其右子树继续如此深入。
    while(treeNode!=null||MyStack.top!=-1){
      while (treeNode!=null){
        push(treeNode);
        System.out.println(treeNode.data);
        treeNode = treeNode.lTreeNode;
      }
      TreeNode treeNode9 = pop();
      treeNode = treeNode9.rTreeNode;
    }
  }
  //沿左子树不断深入,获取栈顶元素，判断是否有右子树,且没后遍历过，如果满足条件，再从右子树的左子树继续深入
  //如果不满足条件，直接出栈
  static void notRecursionEnd(TreeNode treeNode){
    while(treeNode!=null||MyStack.top!=-1){
      while (treeNode!=null){
        push(treeNode);
        treeNode = treeNode.lTreeNode;
      }
      TreeNode treeNode9 = getTop();
      if(treeNode9.rTreeNode!=null && !isINIA(treeNode9.rTreeNode.data)){
        treeNode = treeNode9.rTreeNode;
      }else {
        TreeNode treeNode10 = pop();
        System.out.println(treeNode10.data);
        putIA(treeNode10.data);
        treeNode = null;
      }
    }
  }

  public static void main(String[] args){
    //traverseTree(treeNode8);
    //非遍历方式实现中序遍历
    System.out.println("----");
    //notRecursionMiddle(treeNode8);
    //notRecursionFrist(treeNode8);
    notRecursionEnd(treeNode8);

  }


}
