package slh.bean;
/**
* @Description:    平衡二叉树
* @Author:         ShiLinghuai
* @CreateDate:     2018/11/7 10:50
* @UpdateUser:     ShiLinghuai
* @UpdateDate:     2018/11/7 10:50
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class BalanceBinaryTree {
  //节点的平衡因子的绝对值大于1，则需要旋转
  //旋转类型1，LL型，RR型，LR型，RL型。
  //LL型：直接右旋
  //RR型：直接左旋
  //LR型：
  //获取当前节点的左子树深度
  //获取当前节点的右子树深度
  static class BalanceTree{
    int data;
    BalanceTree lBalanceTree;
    BalanceTree rBalanceTree;
    int balanceFactor;

    public BalanceTree(int data, BalanceTree lBalanceTree, BalanceTree rBalanceTree) {
      this.data = data;
      this.lBalanceTree = lBalanceTree;
      this.rBalanceTree = rBalanceTree;
    }
  }
  int getDeep(BalanceTree balanceTree){
    if(balanceTree ==null){
      return 0;
    }else {
      int left = getDeep(balanceTree.lBalanceTree);
      int right = getDeep(balanceTree.rBalanceTree);
      return 1+Math.max(left,right);
    }
  }
  static BalanceTree root = new BalanceTree(50,null,null);
  void middleTraverse(BalanceTree balanceTree){
    middleTraverse(balanceTree.lBalanceTree);
    int left = getDeep(balanceTree.lBalanceTree);
    int right = getDeep(balanceTree.rBalanceTree);
    balanceTree.balanceFactor = left - right;
    middleTraverse(balanceTree.rBalanceTree);
  }
  BalanceTree getNotBalance(BalanceTree balanceTree){
    middleTraverse(balanceTree.lBalanceTree);
    if(balanceTree.balanceFactor>1||balanceTree.balanceFactor<-1){
      return balanceTree;
    }
    middleTraverse(balanceTree.rBalanceTree);
    return null;
  }
  //ll型旋转
  void llAround(BalanceTree balanceTree){
    BalanceTree balanceTreeTmp = balanceTree;
    BalanceTree balanceTreeLeftTmp = balanceTree.lBalanceTree;
    balanceTree = balanceTreeLeftTmp;
    balanceTree.rBalanceTree = balanceTreeTmp;
  }
  //rr旋转
  void  rrAround(BalanceTree balanceTree){
    BalanceTree balanceTreeTmp = balanceTree;
    BalanceTree balanceTreeRightTmp = balanceTree.rBalanceTree;
    balanceTree = balanceTreeRightTmp;
    balanceTree.lBalanceTree = balanceTreeTmp;
  }
  //lr情况
  void lrAround(BalanceTree balanceTree){
    rrAround(balanceTree.lBalanceTree);
    llAround(balanceTree);
  }
  //rl情况
  void rlAround(BalanceTree balanceTree){
    llAround(balanceTree.rBalanceTree);
    rrAround(balanceTree);
  }
  void insert(BalanceTree balanceTree){
    //插入平衡树节点
    //和二叉排序树的插入相类似，和根节点比较，大于根节点插入右孩子，小于根节点插入左孩子
    BalanceTree balanceTreeTab = root;
    while (balanceTreeTab!=null){
      if(balanceTree.data>balanceTreeTab.data){
        if(balanceTreeTab.rBalanceTree!=null){
          balanceTreeTab = balanceTreeTab.rBalanceTree;
        }else {
          balanceTreeTab.rBalanceTree = balanceTree;
          balanceTreeTab = null;
        }
      }else {
        if(balanceTreeTab.lBalanceTree!=null){
          balanceTreeTab = balanceTreeTab.lBalanceTree;
        }else {
          balanceTree.lBalanceTree = balanceTree;
          balanceTreeTab = null;
        }
      }
    }
    //插入的时候重新赋值平衡因子。
    //计算平衡因子,中序遍历根节点，重新计算树的平衡因子
    middleTraverse(root);
    BalanceTree notBalance = getNotBalance(root);
    //判断平衡因子
    if(notBalance!=null){
      //进行旋转
      //ll型旋转
      if(notBalance.lBalanceTree!=null&&notBalance.lBalanceTree.lBalanceTree!=null){
        llAround(notBalance);
      }else if(notBalance.lBalanceTree!=null&&notBalance.rBalanceTree!=null){
        lrAround(notBalance);
      }else if(notBalance.rBalanceTree!=null&&notBalance.lBalanceTree!=null){
        rlAround(notBalance);
      }else if(notBalance.rBalanceTree!=null&&notBalance.rBalanceTree!=null){
        rrAround(notBalance);
      }
    }
  }
}
