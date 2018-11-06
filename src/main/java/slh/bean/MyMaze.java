package slh.bean;

public class MyMaze {
  //入口1,1  出口8,2
  static int [][]map={
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
  };
  //0,往东
  //1，往南
  //2，往西
  //3，往北
  //返回0，代表该方向走不通
  static boolean canMove(int x,int y,int z){
    if(z==0){
      if(map[x][y+1]==0){
        return true;
      }else {
        return false;
      }
    }
    if(z==1){
      if(map[x+1][y]==0){
        return true;
      }else {
        return false;
      }
    }
    if(z==2){
      if(map[x][y-1]==0){
        return true;
      }else {
        return false;
      }
    }
    if(z==3){
      if(map[x-1][y]==0){
        return true;
      }else {
        return false;
      }
    }
    return false;
  }
  class Location{
    //横坐标
    int x;
    //纵坐标
    int y;

    public Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  //栈
  static class MyStack{
    static Location[] locations = new Location[1000] ;
    static int top = -1;
  }
  static void push(Location location){
    MyStack.locations[++MyStack.top]=location;
  }
  static Location pop(){
    return MyStack.locations[MyStack.top--];
  }
  static Location move(Location location,int z){
    if(z==0){
      MyMaze myMaze = new MyMaze();
      MyMaze.Location newLocation = myMaze.new Location(location.x,location.y+1);
      return newLocation;
    }else if(z==1){
      MyMaze myMaze = new MyMaze();
      MyMaze.Location newLocation = myMaze.new Location(location.x+1,location.y);
      return newLocation;
    }else if(z == 2){
      MyMaze myMaze = new MyMaze();
      MyMaze.Location newLocation = myMaze.new Location(location.x,location.y-1);
      return newLocation;
    }else if(z ==3){
      MyMaze myMaze = new MyMaze();
      MyMaze.Location newLocation = myMaze.new Location(location.x-1,location.y);
      return newLocation;
    }
    return null;
  }
  //探测
  static Location feel(Location location){
    MyMaze.Location newLocation = null;
    int count = 0;
    for(int direction=0;direction<4;direction++){
      if(canMove(location.x,location.y,direction)){
        map[location.x][location.y] = 1;
        push(location);
        newLocation = move(location,direction);
        map[newLocation.x][newLocation.y] = 1;
        break;
      }else {
        count++;
      }
    }
    if(count == 4){
      newLocation= pop();
    }
    return newLocation;
  }
  static int [][]map2={
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
  };
  public static void main(String[] args){
    //规定先往东走，再往南走，再往西走，再往北走，走一步方块值置为1，且准备往一下步走，可以走则走，不可以走则退一步，继续探测
    //可以走的方块。
    MyMaze myMaze = new MyMaze();
    MyMaze.Location startLocation = myMaze.new Location(1,1);
    MyMaze.Location secondL = feel(startLocation);
    while (MyStack.top != -1){
      secondL = feel(secondL);
      System.out.println(secondL.x+"---"+secondL.y);
      if(secondL.x==8&&secondL.y==2){
        break;
      }
    }
  }
}
