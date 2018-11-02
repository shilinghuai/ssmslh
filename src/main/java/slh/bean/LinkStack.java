package slh.bean;

public class LinkStack {
  private Element base;
  private Element top;

  class Element
  {
    public Step data;
    public Element next;
  }

  /**
   * 初始化栈
   * */
  public void initStack()
  {
    top = new Element();
    base = new Element();
    top.data=null;
    top.next=base;
    base.data=null;
    base.next=null;
  }

  /**
   * 入栈
   * */
  public void push(Step o)
  {
    Element e = new Element();
    e.data = o;
    if(top.next==base)//第一次入栈操作
    {
      e.next=base;
      top.next=e;
    }else
    {
      e.next=top.next;
      top.next=e;
    }

  }

  /**
   * 出栈
   * */
  public Step pop()
  {
    Step o = null;
    if(top.next==base)
    {
      System.out.println("栈中没有元素！");
      return o;
    }else
    {
      o = top.next.data;
      //System.out.println("出栈操作"+o);
      top.next=top.next.next;
    }
    return o;
  }
  /**
   * 判断栈是否为空
   * */
  public Boolean isEmpty()
  {
    if(top.next==base)
    {
      return true;
    }
    return false;
  }
  /**
   * 打印栈
   * */
  public void print()
  {
    System.out.print("打印栈：");
    Element temp =top;
    while(temp.next!=base)
    {
      System.out.print(temp.next.data+"\t");
      temp =temp.next;
    }
    System.out.println();
  }
}
