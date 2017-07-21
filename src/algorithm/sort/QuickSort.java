package algorithm.sort;

/**
 * Created by think on 2016/9/16.
 */
public class QuickSort {
    public static void main(String[] args) {
        long staruTime = System.currentTimeMillis();
        int[] num = new int[3000000];
        for (int i = 0; i < num.length; i++)
            num[i] = (int) (Math.random() * 100);

//        for (int n : num)
//            System.out.print(n + " ");
        System.out.println();

        quickSort(num, 0, num.length - 1);
//        for (int i : num)
//            System.out.print(i + " ");
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println((endTime - staruTime) + "ms");
    }

    public static void quickSort(int[] num, int l, int r) {
        if (l < r) {
            int key = num[l];
//            System.out.println("The key:" + num[l]);
            int i = l;
            int j = r;

            while (i < j) {
                while (num[j] > key)
                    j--;
                if (i < j)
                    num[i++] = num[j];

                while (num[i] < key)
                    i++;
                if (i < j)
                    num[j--] = num[i];
            }
            num[i] = key;
//            for (int n : num)
//                System.out.print(n + " ");
//            System.out.println();
            quickSort(num, l, i - 1);
            quickSort(num, i + 1, r);
        }
    }
}
