package LeetCodeChina.Easy;

public class FirstBadVersion {

    /**
     * https://www.cnblogs.com/xiejunzhao/p/7912973.html
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int res =-1;

        while (start <= end){

            //此处无法理解
            //如果一共只有奇数个，并且最后一个是错误版本：
            //3 versions
            // 3 is the first bad version.
            //采用 int middle = start/2 + end/2; 会出现求和和少一的情况，采用 middle = start + (end- start)/2; 会更优化
            // int middle = start + (end- start)/2;
            int middle = start + (end- start)/2;
            if (isBadVersion(middle)){
                res = middle;
                end = middle-1;
            }
            else {
                start = middle+1;
            }

        }
        return res;
    }


    private  boolean isBadVersion(int version){

        return false;
    }
}
