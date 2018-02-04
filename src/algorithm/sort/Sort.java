package algorithm.sort;

/**
 * @author 李文浩
 * @date 2018/1/25
 */
public class Sort {
    public static void main(String[] args) {
        long staruTime = System.currentTimeMillis();
//        int[] num = {10, 2, 6, 3, 50, 26, 34, 6};
        int[] num = new int[20];
        for (int i = 0; i < num.length; i++)
            num[i] = (int) (Math.random() * 10000);
        System.out.print("排序前: ");
        for (int n : num)
            System.out.print(n + " ");
        System.out.println();
        //插入排序
        Insert.sort2(num);
        //希尔排序
//        Shell.sort(num);

        System.out.print("排序后: ");
        for (int i : num)
            System.out.print(i + " ");
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println((endTime - staruTime) + "ms");
    }
}
