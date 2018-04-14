package LeetCodeChina.Easy;

public class GuessNumber {

    /**
     * 二分查找
     * @param n
     * @return
     */
    public int guessNumber(int n) {

        int start = 1;
        int end = n;

        while (start <= end){
            //此处一定注意 (start + end) 可能会产生溢出
            int middle = start/2 +end/2;
            if (guess(middle)==1){
                start = middle +1;
            }
            else if (guess(middle) == -1){
                end = middle-1;
            }
            else {
                return middle;
            }
        }

        return start;
      //  return helper(1,n);
    }

    public int helper(int start, int end){
        if(start == end) return start;
        int mid = Math.toIntExact(((long)start+(long)end)/2);
        int r = 0;
        if(guess(mid) == 0) r = mid;
        else if(guess(mid) == 1) r = helper(mid+1, end);
        else if(guess(mid) == -1) r = helper(start, mid-1);
        return r;
    }

    private int guess(int num){

        return -1;
    }



}
