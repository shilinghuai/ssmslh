package slh.bean;

public class MergeLinked {
  /**
  * 取两个递增链表的交集
  * @author      ShiLinghuai
  * @param
  * @return
  * @exception
  * @date        2018/11/2 11:37
  */
  MyLinkNode getIntersection(MyLinkNode myLinkNodeA,MyLinkNode myLinkNodeB){
    MyLinkNode headNode = new MyLinkNode(1,null);
//    for(MyLinkNode myLinkNodeTab=myLinkNodeA;myLinkNodeTab.next!=null;myLinkNodeTab=myLinkNodeTab.next){
//      for(MyLinkNode myLinkNodeTabB = myLinkNodeB;myLinkNodeTabB.next!=null;myLinkNodeTabB=myLinkNodeTabB.next){
//        if(myLinkNodeTab.data==myLinkNodeTabB.data){
//          MyLinkNode newNode  = new MyLinkNode();
//          newNode.data = myLinkNodeTab.data;
//          newNode.next = headNode.next.next;
//          headNode.next = newNode;
//        }
//      }
//    }
    while (myLinkNodeA.next!=null&myLinkNodeB.next!=null){
      if(myLinkNodeA.data<myLinkNodeB.data){
        myLinkNodeA = myLinkNodeA.next;
      }else if(myLinkNodeA.data==myLinkNodeB.data){
        myLinkNodeA = myLinkNodeA.next;
        myLinkNodeB = myLinkNodeB.next;
        myLinkNodeA.next=headNode.next;
        headNode.next=myLinkNodeA;
      }else {
        myLinkNodeB = myLinkNodeB.next;
      }
    }
    return headNode;
  }
  public static void main(String[] args){
    int[] ia = {1,2,3,4,5};
    int[] ib = {3,5,7};
    int[] ic = new int[100];
    int indexIA=0,indexIB=0,indexIC=0;
    while(indexIA<ia.length&&indexIB<ib.length){
      if(ia[indexIA]<ib[indexIB]){
        ic[indexIC++]=ia[indexIA++];
      }else {
        ic[indexIC++] = ib[indexIB++];
        indexIA++;
      }
    }
    MyLinkNode myLinkNode1 = new MyLinkNode(3,null);
    MyLinkNode myLinkNode2 = new MyLinkNode(2,myLinkNode1);
    MyLinkNode myLinkNode3 = new MyLinkNode(1,myLinkNode2);
    MyLinkNode myLinkNode11 = new MyLinkNode(4,null);
    MyLinkNode myLinkNode22 = new MyLinkNode(3,myLinkNode11);
    MyLinkNode myLinkNode33 = new MyLinkNode(2,myLinkNode22);
    MergeLinked mergeLinked = new MergeLinked();
    mergeLinked.getIntersection(myLinkNode33,myLinkNode3);

    System.out.println(ic);
  }

}
