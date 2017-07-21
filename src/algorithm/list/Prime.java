package algorithm.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2016/9/20.
 */
public class Prime {
    public static List<Integer> list;
    static {
        list = new ArrayList<Integer>(40);
        list.add(2);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时
        //0 1 不算做素数,2一定是素数
        for (int n = 3; n <= 2000000; n += 2) {
            if (isPrime(n)) {
                list.add(n);
            }
        }
        for (int i : list) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println("The num is " + list.size());
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isPrime(int n) {
        for (int i = 0; list.get(i) <= (int) Math.sqrt(n); i++) {
            if (n % list.get(i) == 0)
                return false;
        }
        return true;
//        for (int i = 3; i <= (int) Math.sqrt(n); i++)
//            if (n % i == 0)
//                return false;
//        return true;
    }


    public static void prime() {
        for (int n = 0; n <= 200; n ++) {
            if (isPrime(n)) {
                list.add(n);
            }
        }
    }
}
