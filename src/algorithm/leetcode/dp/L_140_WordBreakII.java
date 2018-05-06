package algorithm.leetcode.dp;

import java.util.*;

/**
 * @author 李文浩
 * @date 2018/3/18
 */
public class L_140_WordBreakII {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("cats");
        set.add("cat");
        set.add("and");
        set.add("sand");
        set.add("dog");
        System.out.println(new L_140_WordBreakII().wordBreak("catsanddog", set));
    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {

        int len = s.length();
        boolean[] arrays = new boolean[len + 1];
        arrays[0] = true;
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arrays[j] && dict.contains(s.substring(j, i))) {
                    arrays[i] = true;
//                    System.out.println(s.substring(0, j) + " " + s.substring(j, i));
//                    for (boolean flag : arrays) {
//                        System.out.print(flag + " ");
//                    }
//                    System.out.println();
                    break;
                }
            }
        }
        if (!arrays[len]) {
            return new ArrayList<>();
        }
        ArrayList<String> words = new ArrayList<>();
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        StringBuilder stringBuilder;
        String word;
        for (int i = 1; i <= len; i++) {
            stringBuilder = new StringBuilder();
            int pre = 0;
            for (int j = 1; j <= len; j++) {
                if (arrays[j]) {
                    stringBuilder.append(s.substring(pre, j) + " ");
                    pre = j;
                    if (j < len-1 && arrays[j + 1]) {
                        arrays[j] = false;
                        j++;
                        while (j < len-1 && arrays[j]) {
                            j++;
                        }
                    }
                }
            }
            word = stringBuilder.toString().trim();
//            if (!words.contains(word)) {
//                words.add(word);
//            }
            set.add(word);

        }
        for (String  str  : set) {
            words.add(str);
        }
        return words;
    }
}
