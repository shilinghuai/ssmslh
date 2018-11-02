package slh.bean;

public class Maze {
  public static void main(String[] args) {

    int [][]map={
      {1,1,1,1,1,1,1,1,1,1},
      {1,0,0,1,0,0,0,1,0,1},
      {1,0,0,1,0,0,0,1,0,1},
      {1,0,0,0,0,1,1,0,0,1},
      {1,0,1,1,1,0,0,0,0,1},
      {1,0,0,0,1,0,0,0,0,1},
      {1,0,1,0,0,0,1,0,0,1},
      {1,0,0,0,1,0,1,1,0,1},
      {1,1,0,0,0,0,0,0,0,1},
      {1,1,1,1,1,1,1,1,1,1}
    };//入口在map[1][1],出口在map[8][2]

    int [][]move={{0,-1},{0,1},{-1,0},{1,0}};//上下左右四个移动方向
    LinkStack s = new LinkStack();
    s.initStack();
    LinkStack s1 = new LinkStack();
    s1.initStack();
    path(map,move,s,s1);

    while(!s1.isEmpty())
    {
      Step step = s1.pop();
      System.out.println("("+step.x+","+step.y+")");
    }
  }

  private static int path(int[][] map, int[][] move,LinkStack s,LinkStack s1) {
    Step step = new Step(1, 1, -1);//起始位置
    //map[1][1]=-1;//表示已走过该点
    s.push(step);
    s1.push(step);
    while(!s.isEmpty())
    {
      step=s.pop();
      int x=step.x;
      int y=step.y;
      int d=step.d+1;
      while(d<4)
      {

        int i=x+move[d][0];
        int j=y+move[d][1];
        if(map[i][j]==0 && i>=0 && i<10 && j>=0 &&j<10)//该位置是通的，且不越界
        {
          System.out.println(i+","+j);
          step = new Step(x, y, d);
          s.push(step);//将当前位置压入栈顶
          s1.push(step);

          step = new Step(i, j, d);
          s.push(step);//将当前位置压入栈顶
          s1.push(step);
          x=i;
          y=j;
          map[x][y]=-1;//表示已走过该点

          if(x==8 && y==8)//到达出口
          {
            System.out.println("到达出口");
            return 1;
          }else
          {
            d=0;//到达一个新的点，所以要从新初始化方向，遍历其4个方向是否是通的
          }
        }else
        {
          d++;//下一个方向
        }
      }
    }
    return 0;
  }
}
