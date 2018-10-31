package slh.bean;

public class LinkReverse {
  static class Node<K>{
    K data;
    Node node;
    public Node(K data, Node node) {
      this.data = data;
      this.node = node;
    }

    public K getData() {
      return data;
    }

    public void setData(K data) {
      this.data = data;
    }

    public Node getNode() {
      return node;
    }

    public void setNode(Node node) {
      this.node = node;
    }
  }
  static Node<Integer> node3 = new Node<Integer>(3,null);
  static Node<Integer> node2 = new Node<Integer>(2,node3);
  static Node<Integer> node1 = new Node<Integer>(1,node2);
  //遍历
  public void traverse(Node node){
    System.out.println(node.data);
    if(node.node!=null){
      traverse(node.node);
    }
  }
  //获取某个位置的节点 0,1,2
  public Node getNode(Node node,int index){
    if(index == 0){
      return node;
    }
    Node nodeNew = node;
    for(int ia=1;ia<=index;ia++){
        nodeNew = nodeNew.node;
    }
    return nodeNew;
  }
  int count = 0;
  public int getLength(Node node){
      ++count;
      if(node.node!=null){
        getLength(node.node);
      }
      return count;

  }
  public Node reverse(Node node,int length){
    Node last = getNode(node,length-1);
    for(int ib=length-1;ib>=0;ib--){
      if(ib==0){
        getNode(node,ib).node = null;
        break;
      }
      getNode(node,ib).node = getNode(node,ib-1);
    }
    return last;
  }
  public static void main(String[] args){
    LinkReverse linkReverse = new LinkReverse();
    LinkReverse linkReverse1 = new LinkReverse();
    linkReverse.traverse(node1);
    System.out.println("获取的node："+linkReverse.getNode(node1, 1).getData());
    System.out.println("获取的长度："+linkReverse1.getLength(node1));
    System.out.println("开始反转：");
    linkReverse.traverse(linkReverse.reverse(node1,linkReverse.getLength(node1)));
  }


}
