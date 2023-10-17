import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]

        // 左右扫描指针
        int i = lo, j = hi+1;
        Comparable v = a[lo];   //切分元素
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        //将v = a[j]放入正确的位置
        exch(a, lo, j);
        // a[lo..j-1] <= a[j] <= a[j+1..hi] 达成
        return j;
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        // 切分
        int j = partition(a, lo, hi);
        // 将左半部分a[lo .. j-1]排序
        sort(a, lo, j - 1);
        // 将右半部分a[j+1 .. hi]排序
        sort(a, j + 1, hi);
    }

    public static void sort(Comparable[] a) {
        // 消除对输入的依赖
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
}
