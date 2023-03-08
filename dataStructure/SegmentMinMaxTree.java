package dataStructure;

public class SegmentMinMaxTree {

    int[] min;
    int[] max;
    int n;

    int[] arr;

    SegmentMinMaxTree(int n) {
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        this.n = n;

        min = new int[4 * n];
        max = new int[4 * n];
        initMin(1, 0, n - 1);
        initMax(1, 0, n - 1);
    }

    private int initMin(int node, int start, int end) {
        if (start == end) {
            return min[node] = start;
        } else {
            int mid = (start + end) / 2;
            return min[node] = Math.min((initMin(leftChild(node), start, mid)),
                    initMin(rightChild(node), mid + 1, end));
        }
    }

    private int initMax(int node, int start, int end) {
        if (start == end) {
            return max[node] = start;
        } else {
            int mid = (start + end) / 2;
            return max[node] = Math.max((initMax(leftChild(node), start, mid)),
                    initMax(rightChild(node), mid + 1, end));
        }
    }

    int max(int left, int right) {
        return getMax(1, 0, n - 1, left, right);
    }

    private int getMax(int node, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return -1;
        } else if (left <= start && end <= right) {
            return max[node];
        } else {
            int mid = (start + end) / 2;
            return Math.max((getMax(leftChild(node), start, mid, left, right)),
                    getMax(rightChild(node), mid + 1, end, left, right));
        }
    }

    int min(int left, int right) {
        return getMin(1, 0, n - 1, left, right);
    }

    private int getMin(int node, int start, int end, int left, int right) {
        if (end < left || right < start) {
            return Integer.MAX_VALUE;
        } else if (left <= start && end <= right) {
            return min[node];
        } else {
            int mid = (start + end) / 2;
            return Math.min((getMin(leftChild(node), start, mid, left, right)),
                    getMin(rightChild(node), mid + 1, end, left, right));
        }
    }

    void updateVal(int index0, int index1) {
        updateMax(1, 0, n - 1, index0, arr[index1]);
        updateMax(1, 0, n - 1, index1, arr[index0]);
        
        updateMin(1, 0, n - 1, index0, arr[index1]);
        updateMin(1, 0, n - 1, index1, arr[index0]);

        int tmp = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = tmp;
    }

    private int updateMin(int node, int start, int end, int index, int newVal) {
        if (index < start || end < index) {
            return min[node];
        } else if (start == end) {
            return min[node] = newVal;
        } else {
            int mid = (start + end) / 2;
            return min[node] = Math.min((updateMin(leftChild(node), start, mid, index, newVal)),
                updateMin(rightChild(node), mid + 1, end, index, newVal));
        }
    }

    private int updateMax(int node, int start, int end, int index, int newVal) {
        if (index < start || end < index) {
            return max[node];
        } else if (start == end) {
            return max[node] = newVal;
        } else {
            int mid = (start + end) / 2;
            return max[node] = Math.max((updateMax(leftChild(node), start, mid, index, newVal)),
                updateMax(rightChild(node), mid + 1, end, index, newVal));
        }
    }

    private int leftChild(int i) {
        return i * 2;
    }

    private int rightChild(int i) {
        return i * 2 + 1;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + " ");
        }
        sb.append('\n');
        return sb.toString();
    }
}