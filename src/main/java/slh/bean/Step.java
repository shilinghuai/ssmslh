package slh.bean;

public class Step {
  int x;//横坐标
  int y;//纵坐标
  int d;//移动方向，取值为0,1,2,3。分别表示上下左右4个方向。

  public Step(int x,int y,int d)
  {
    this.x=x;
    this.y=y;
    this.d=d;
  }
}
