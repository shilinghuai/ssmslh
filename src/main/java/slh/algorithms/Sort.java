package slh.algorithms;

public class Sort {
    //冒泡，相邻的两个进行比较，如果前者大于后者这调换位置，这样一轮下来最后那个是最大的。
    //选择：从待排序的数据元素里找到最大的一个，放在最后。
    //快速排序：选取一个数作为标准，通过交换使左边的数都比这个数小，右边的都比这个数大。再对
    //左右两边的数在进行划分排序，一直重复，直到无法进行排序。
    //归并排序：归并排序的核心是合并有序组。初始时两两分组，进行排序，之后44分组排序，88排序1616排序。
    //冒泡排序
    static void bubbling(int[] ia){
        int length = ia.length;
        //外层控制循环的次数
        for(int a=0;a<length-1;a++){
            int c = 1;
            //内层控制比较的次数
            for(int b=0;b<length-c;b++){
                if(ia[b]>ia[b+1]){
                    int d = ia[b];
                    ia[b] = ia[b+1];
                    ia[b+1] = d;
                }
            }
            c++;

        }
        System.out.print(ia);
    }

    //选择排序
    static void chooseSort(int[] ia){
        int length = ia.length;
        //外层控制循环次数
        for(int a=0;a<length-1;a++){
            //内层控制比较次数
            for(int b=a+1;b<length;b++){
                if(ia[a]>ia[b]){
                    //需要调换
                    int c = ia[a];
                    ia[a] = ia[b];
                    ia[b] = c;
                }
            }
        }
    }

    //快速排序
    static void fastSort(int[] ia){
        
    }
    public static void main(String[] args){
        int[] ia = {4,1,2,5,3,9,8,6,7};
        chooseSort(ia);
        int[] ib = null;
    }


}
