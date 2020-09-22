package src.com.Sort;

public class BubbleSort {
    public static void main(String[] args){
        //冒泡排序每次都是从首位开始
        int i = 0, j = 0, temp = 0,count = 0,tempPosition = 0;
        int[] sort = {2,3,1,5,7,4,6};
        //NormalSort.normalSort(sort, i, j, temp,count);
        //Optimal.optimalSort(sort,i,j,temp,count);
        Optimal.optimalSortPro(sort,i,j,temp,count,tempPosition);
    }
}

class NormalSort {
    public static int[] normalSort(int[] sort, int i, int j, int temp,int count) {
        if ("null".equals(sort)) {
            System.out.println("当前序列为空");
            return null;
        }
        for (i = 1; i < sort.length; i++) { //第几趟排序,总共排序n-1趟
            for (j = 0; j < sort.length - i; j++) { //每一趟需要比较的次数为n-i
                if (sort[j] > sort[j + 1]) {
                    temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;
                }
                System.out.format("第%d趟 第%d次比较遍历的结果：", i ,j);
                for (int k = 0; k < sort.length; k++) {
                    System.out.print(sort[k] + " ");
                }
                count++;
                System.out.println(count);
            }
        }
        return sort;
    }
}

class Optimal {
    public static int[] optimalSort(int[] sort, int i, int j, int temp,int count) {
        if ("null".equals(sort)) {
            System.out.println("当前序列为空");
            return null;
        }
        for (i = 1; i < sort.length; i++) { //第几趟排序,总共排序n-1趟
            int flag = 1;
            for (j = 0; j < sort.length - i; j++) { //每一趟需要比较的次数为n-i
                if (sort[j] > sort[j + 1]) {
                    temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;
                    flag = 0;
                }
                System.out.format("第%d趟 第%d次比较遍历的结果：", i ,j);
                for (int k = 0; k < sort.length; k++) {
                    System.out.print(sort[k] + " ");
                }
                count++;
                System.out.println(count);
            }
            if (flag == 1) {
                return sort;
            }
        }
        return sort;
    }

    public static int[] optimalSortPro(int[] sort, int i, int j, int temp,int count,int tempPostion) {
        if ("null".equals(sort)) {
            System.out.println("当前序列为空");
            return null;
        }
        int len = sort.length-1;
        for (i = 1; i < sort.length; i++) { //第几趟排序,总共排序n-1趟
            int flag = 1;
            for (j = 0; j < len; j++) { //每一趟需要比较的次数为n-i
                if (sort[j] > sort[j + 1]) {
                    temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;
                    flag = 0;
                    tempPostion = j; //最后一次比较的位置
                }
                System.out.format("第%d趟 第%d次比较遍历的结果：", i ,j);
                for (int k = 0; k < sort.length; k++) {
                    System.out.print(sort[k] + " ");
                }
                count++;
                System.out.println(count);
            }
            len = tempPostion;
            if (flag == 1) {
                return sort;
            }
        }
        return sort;
    }
}

