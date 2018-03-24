package SwordOffer;

public class QuickSort {

    /**
     * http://blog.csdn.net/morewindows/article/details/6684558
     *  分治法的思想
     * @param s 表示待排序的数组
     * @param l 表示左边指针
     * @param r 表示右边指针
     * @return
     */
    public static int adjustArray(int[] s,int l,int r){
        int i =l,j=r;
        //s[l] 就是 s[i] 第一个坑
        int x = s[l];   //左边的第一个数组为坑的开始，当然，可以改
   //如果 j 大于或者等于 i，说明已经有序了
    while (i<j){
        //从左往右开始
        while(i<j && s[j]>=x)
            j--;
        System.out.println("i: "+ i + "-"+"j: "+j);
        if (i<j){
            //将 s[j] 填到 s[i]中，s[j] 形成了一个新的坑
            s[i] = s[j];
            i++;
        }
        //从右往左开始
        while (i < j && s[i] <x)
            i++;
        if (i<j){
            //将 s[i] 填到 s[j] 中，s[i] 形成一个新的坑
            s[j] = s[i];
            j--;
        }
    }
        //退出时，i等于j。将x填到这个坑中。
        s[i] = x;

        return i;
    }

    public static void quick_sort(int[] s ,int l,int r){
        //如果 l 大于或者等于 r，说明已经有序了
        if (l<r){
            int i = adjustArray(s,l,r);
            //递归调用 i 的两边，形成新的
            quick_sort(s,l,i-1);
            quick_sort(s,i+1,r);
        }
    }

    /**
     * 快排
     * @param s  待排序数组
     * @param l  左侧指针
     * @param r  右侧指针
     */
    public static void quick_sort_01(int[]s,int l,int r){
        int i=l,j=r;
        int x = s[i]; //占坑

        if (i<j){
            while (i<j){

                //从右边向左边搜索
                while (i<j && s[j]>=x)
                    j--;
                if (i<j){
                    s[i] = s[j];
                    i++;
                }

                //从左边向右边搜索
                while (i<j && s[i] < x)
                    i++;
                if (i<j){
                    //将 s[i] 填到 s[j] 中，s[i] 形成一个新的坑
                    s[j] = s[i];
                    j--;
                }
            }
            s[i] = x;
        }


    }

    public static void main(String[] args) {
        int [] s = {6,57,88,60,42,83,73,48,85};
        quick_sort(s,0,8);
        for (int i=0;i<s.length;i++){
            System.out.print(s[i]+" ");
        }
    }


}
