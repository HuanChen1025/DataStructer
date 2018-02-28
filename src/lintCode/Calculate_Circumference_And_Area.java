package lintCode;

public class Calculate_Circumference_And_Area {
    /**
     * @param r: a Integer represent radius
     * @return: the circle's circumference nums[0] and area nums[1]
     */
    public static double[] calculate(int r) {
        // write your code here
        double [] result = new double[2];
        double pi =3.14;
        result[0] = 2*pi*r;
        result[1] = pi*r*r;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculate(2));

    }
}
