package isp.lab5.exercise1;

import java.util.Arrays;
import java.util.Comparator;

public class TESTEXAMEN {
    public static void main(String[] args) {
        String[] ar = {"c", "d", "b", "a", "e"};
        InnerClass in = new InnerClass();
        Arrays.parallelSort(ar, in);
        for (String ignored : ar)
            System.out.println(Arrays.binarySearch(ar, "b"));

    }

}

class InnerClass implements Comparator<String> {
    public int compare(String s1, String s2) {
        return s2.compareTo(s1);
    }
}
