package LeetCodeChina.PrimaryAlgorithm.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。

 * 1. 如果 n 是3的倍数，输出“Fizz”；

 * 2. 如果 n 是5的倍数，输出“Buzz”；

 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
public class FizzBuzz {

    public List<String> fizzBuzz_01(int n) {
        List<String> results = new ArrayList<>();

        for (int i=1;i<=n;){
            if (i%15==0){
                results.add("FizzBuzz");
                i++;

            }
            else if (i%5 == 0){
                results.add("Buzz");
                i++;

            }
            else if (i%3==0){
                results.add("Fizz");
                i++;

            }
            else if (i%3!=0 && i %5 !=0){
                results.add(String.valueOf(i));
                i++;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> results = fizzBuzz.fizzBuzz_01(90);
        System.out.println();

    }
}
