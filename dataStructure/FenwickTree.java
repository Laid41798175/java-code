package dataStructure;

public class FenwickTree {

    long[] tree;
    int n;

    FenwickTree(long[] arr) {
        n = arr.length - 1;
        tree = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            update(i, arr[i] - arr[i - 1]);
        }
    }
    
    void update (int index, long diff){
        while (index <= n) {
            tree[index] += diff;
            index += (index & -index);
        }
    }

    long sum (int to) {
        long sum = 0;
        while (to > 0) {
            sum += tree[to];
            to -= (to & -to);
        }
        return sum;
    }

    long sum (int from, int to) {
        return sum(to) - sum(from - 1);
    }

    void print() {
        System.out.println("PRINT");
        for (int i = 1; i <= n; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }
}