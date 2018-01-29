package algorithm.sort;

/**
 * @author 李文浩
 * @date 2018/1/25
 */
public class Insert {

    /**
     * 通过交换进行插入排序
     *
     * @param a
     */
    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 通过将较大的元素都向右移动
     *
     * @param a
     */
    public static void sort2(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {

            int num = a[i + 1];
            for (int j = i; j > 0; j--) {
                if (a[j] < num) {
                    for (int m = i; m > j; m--) {
                        a[m + 1] = a[m];
                    }
                    a[j + 1] = num;
                }
            }
        }
    }
}
