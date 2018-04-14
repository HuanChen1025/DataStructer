package LeetCodeChina.Easy;

/**
 * 初始位置 (0, 0) 处有一个机器人。给出它的一系列动作，判断这个机器人的移动路线是否形成一个圆圈，
 * 换言之就是判断它是否会移回到原来的位置。

 * 移动顺序由一个字符串表示。每一个动作都是由一个字符来表示的。机器人有效的动作有 R（右），L（左），U（上）和 D（下）。
 * 输出应为 true 或 false，表示机器人移动路线是否成圈。
 */
public class JudgeCircle {

    /**
     * 采用数组，耗费时间空间更多，直接采用 x 和 y 值会更加合适，速度快
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() ==0)
            return true;
        //int[] move = new int[2];
        int x =0,y=0;


        for (int i=0;i<moves.length();i++){
            if (moves.charAt(i)=='U')
               // move[1] +=1;
                y++;
            else if (moves.charAt(i)=='D')
                //move[1] -=1;
                y--;
            else if (moves.charAt(i)=='L')
                //move[0] -=1;
                x--;
            else if (moves.charAt(i)=='R')
                //move[0] +=1;
                x++;
        }
        if (x == 0 && y == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        JudgeCircle judgeCircle = new JudgeCircle();
        System.out.println(judgeCircle.judgeCircle("LL"));
    }
}
