package slh.bean;

/**
 * btree特点：m阶的btree树，根节点的关键值的数量[1，m-1],非根节点的关键值的
 * 数量m/2（向上取整）-1左闭，m-1 右闭
 *
 * @Description: 先写btree的数据结构，再写插入算法，再写删除算法
 * @Author: ShiLinghuai
 * @CreateDate: 2018/11/8 9:50
 * @UpdateUser: ShiLinghuai
 * @UpdateDate: 2018/11/8 9:50
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class BTree {
  //3阶btree,关键值1-2，度1-3
  //因为要会发生溢出现象，特意把数组大小改为m+1
  int[] data = new int[3];
  BTree[] bTrees = new BTree[4];
  static BTree root = new BTree();

  //插入算法，往节点里插入数据，需要保证插入的总是叶子节点，如果不会发生溢出，则
  //直接插入，如果发生溢出了，顶到父节点上，父节点发生溢出继续顶，顶完为止。
  void insertData(int dataN) {
    BTree bTreeTab = root;
    //找到叶子节点
    //获取深度，根据深度找到叶子节点
    int deep = getDeep(root);
    int ia = 1;
    //如果深度是1，返回root
    //如果深度大于1，
    push(bTreeTab);
    while (ia < deep) {
      //排序，按不满的情况排序
      boolean flag = true;
      for (int ib = 0; ib < data.length; ib++) {
        if (dataN > data[ib]) {
          bTreeTab = bTreeTab.bTrees[ib + 1];
          flag = false;
        }
      }
      if (flag) {
        bTreeTab = bTreeTab.bTrees[0];
      }
      push(bTreeTab);
      ia++;
    }
    //bTreeTab此时是叶子节点
    //再进行插入，此时考虑溢出的情况，如果溢出
    //进行溢出处理
    //获取叶子节点，进行插入排序，如果溢出，把中间元素移到父级节点上，如果父节点溢出，继续
    //分裂。
    //先想最简单的分裂，传入节点链，排序，取中间关键值，上移到父节点上，创建两个新节点分别
    //存储，修改父指针，如果父节点也发生溢出，把父节点的中间关键值提上去，然后把父节点劈成两
    //半，再修改上面的指针指向。
    BTree bTreeLeaf = pop();
    while (bTreeLeaf != null) {
      boolean flag = isFull(bTreeLeaf);
      if (flag) {
        //继续插入
        //获取要插入的位置
        insertTree(dataN, bTreeLeaf);
        //分裂,获取左细胞
        BTree leftCell = getLeftCell(bTreeLeaf);
        BTree rightCell = getRightCell(bTreeLeaf);
        int theData = bTreeLeaf.data[(data.length - 1) / 2]; //这个是中间节点
        BTree parentsBree = pop();
        //判断是否有父节点
        if (parentsBree == null) {
          BTree newParents = new BTree();
          newParents.data[0] = theData;
          newParents.bTrees[0] = leftCell;
          newParents.bTrees[1] = rightCell;
          break;
        } else {
          //将数据放到父节点里
          int locationT = insertTree(dataN, parentsBree);
          //修改父节点的指针。
          if (locationT < 1) {
            //其他节点数据往后移，
            parentsBree.bTrees[0] = leftCell;
            parentsBree.bTrees[1] = rightCell;
          } else {
            parentsBree.bTrees[parentsBree.data.length-2] = leftCell;
            parentsBree.bTrees[parentsBree.data.length-1] = rightCell;
          }
          //判断是否溢出
          if (isOverflow(parentsBree)) {
            bTreeLeaf = pop();
          } else {
            break;
          }
        }
      } else {
        //插入
        //获取要插入的位置
        insertTree(dataN, bTreeLeaf);
        break;
      }
    }
  }

  private int insertTree(int dataN, BTree parentsBree) {
    int locationT = 0;
    for (int bTia = 0; bTia < parentsBree.data.length - 1; bTia++) {
      if (dataN < parentsBree.data[bTia]) {
        locationT = bTia;
      }
    }
    //插入①先后移
    for (int bTib = parentsBree.data.length - 2; bTib > locationT; bTib--) {
      parentsBree.data[bTib + 1] = parentsBree.data[bTib];
    }
    parentsBree.data[locationT] = dataN;
    return locationT;
  }

  BTree getLeftCell(BTree bTree) {
    //获取左细胞
    BTree bLTree = new BTree();
    for(int bLia = 0;bLia<bLTree.data.length/2-1;bLia++){
      bLTree.data[bLia] = bTree.data[bLia];
    }
    for(int bLib = 0;bLib<bLTree.data.length/2;bLib++){
      bLTree.bTrees[bLib] = bTree.bTrees[bLib];
    }
    return bLTree;
  }

  BTree getRightCell(BTree bTree) {
    BTree bRTree = new BTree();
    for(int rIa = bTree.data.length/2-1,rIb = 0;rIa<bTree.data.length;rIa--,rIb++){
      bRTree.data[rIb] = bTree.data[rIa];
    }
    for(int rIa = bTree.data.length/2-1,rIb = 0;rIa<bTree.data.length;rIa--,rIb++){
      bRTree.bTrees[rIb] = bRTree.bTrees[rIa];
    }
    return bRTree;
  }

  //入栈
  void push(BTree bTree) {

  }

  //出栈
  BTree pop() {
    return null;
  }

  //是否是叶子节点是的话返回true
  boolean isLeaf(BTree bTree) {
    boolean flag = true;
    for (int ia = 0; ia < bTrees.length - 1; ia++) {
      if (bTrees[ia] != null) {
        flag = false;
      }
    }
    return flag;
  }

  boolean isFull(BTree bTree) {
    if (bTree.data[data.length - 2] == 0) {
      return false;
    } else {
      return true;
    }
  }

  boolean isOverflow(BTree bTree) {
    if (bTree.data[data.length - 1] != 0) {
      return true;
    } else {
      return false;
    }
  }

  int getDeep(BTree bTree) {
    int high = 0;
    while (bTree != null) {
      boolean flag = true;
      for (int ia = 0; ia < bTree.bTrees.length - 1; ia++) {
        if (bTree.bTrees[ia] != null) {
          high++;
          bTree = bTree.bTrees[ia];
          flag = false;
          break;
        }
      }
      if (flag) {
        bTree = null;
      }
    }
    return high;
  }

}
