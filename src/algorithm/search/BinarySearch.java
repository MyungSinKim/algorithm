package algorithm.search;

/**
 * http://www.cnblogs.com/ider/archive/2012/04/01/binary_search.html
 *
 * @author 李文浩
 * @version 2017/8/5.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarysearch(a, 0, 5, 2));
    }

    int binarysearch(int array[], int low, int high, int target) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (array[mid] > target)
            return binarysearch(array, low, mid - 1, target);
        if (array[mid] < target)
            return binarysearch(array, mid + 1, high, target);

        //if (midValue == target)
        return mid;
    }

    int bsearchWithoutRecursion(int array[], int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] > target)
                high = mid - 1;
            else if (array[mid] < target)
                low = mid + 1;
            else //find the target
                return mid;
        }
        //the array does not contain the target
        return -1;
    }


}
