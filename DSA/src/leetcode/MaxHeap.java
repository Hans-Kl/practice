package leetcode;

/**
 * @author klhans
 */
public class MaxHeap implements Queue {
    private int[] data;
    private int capacity;
    private int size;

    public MaxHeap(int capacity) {
        // 下标 0 不存元素，因此需要空间为 capacity + 1
        this.data = new int[capacity + 1];
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int peek() {
        if (isEmpty()) throw new IllegalArgumentException();
        return data[1];
    }

    @Override
    public void offer(int x) {
        if (size + 1 > capacity) throw new IllegalArgumentException();
        size++;
        data[size] = x;
        shiftUp(size);
    }

    @Override
    public int poll() {
        if (isEmpty()) throw new IllegalArgumentException();
        int res = data[1];
        data[1] = data[size];
        shiftDown(1);
        size--;
        return res;
    }

    private void shiftUp(int index) {
        while (index > 1 && data[index / 2] < data[index]) {
            swap(data, index, index / 2);
            index /= 2;
        }
    }

    private void shiftDown(int index) {
        while (2 * index <= size) {
            int childIndex = 2 * index;
            if (childIndex + 1 >= size && data[childIndex] < data[childIndex + 1]){
                childIndex ++;
            }
            if (data[index] < data[childIndex]){
                swap(data,index,childIndex);
                index = childIndex;
            }else {
                break;
            }
        }
    }

    public void replace(int x){
        if (isEmpty()) throw new IllegalArgumentException();
        data[1] = x;
        shiftDown(1);
    }

    private void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }


}
