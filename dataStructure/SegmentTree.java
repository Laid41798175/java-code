package dataStructure;

public class SegmentTree {

    long[] tree;
    int n;

    SegmentTree(long[] arr) {
        this.n = arr.length - 1;
        tree = new long[4 * n];
        init (arr, 1, 1, this.n);
    }

    private long init (long[] arr, int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            return tree[node] = init(arr, leftChild(node), start, mid)
                    + init(arr, rightChild(node), mid + 1, end);
        }
    }

    long sumVal(int from, int to) {
        return sum(1, 1, n, from, to);
    }

    private long sum(int node, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return 0;
        } else if (left <= start && end <= right) {
            return tree[node];
        } else {
            int mid = (start + end) / 2;
            return sum(leftChild(node), start, mid, left, right) + sum(rightChild(node), mid + 1, end, left, right);
        }
    }

    void updateVal(int index, long orgVal, long newVal) {
        update(1, 1, n, index, newVal - orgVal);
    }

    private void update(int node, int start, int end, int index, long diff) {
        if (index < start || end < index) {
            return;
        } else {
            tree[node] += diff;

            if (start != end) {
                int mid = (start + end) / 2;
                update(leftChild(node), start, mid, index, diff) ;
                update(rightChild(node), mid + 1, end, index, diff) ;
            }
        }
    }

    private int leftChild(int i) {
        return i * 2;
    }

    private int rightChild(int i) {
        return i * 2 + 1;
    }
}