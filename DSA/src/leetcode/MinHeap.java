package leetcode;

/**
 * @author klhans
 */
public class MinHeap implements Queue{
    private int[] data;
    private int capacity;
    private int size;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        data = new int[capacity + 1];
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

    public void offer(int x){
        if (size + 1 > capacity) throw new IllegalArgumentException();
        size++;
        data[size] = x;
        shiftUp(x);
    }

    public int poll(){
        if (size == 0) throw new IllegalArgumentException();
        int res = data[1];
        data[1] = data[size];
        shiftDown(1);
        size--;
        return res;
    }

    @Override
    public int peek() {
        return data[1];
    }

    public void replace(int x){
        data[1] = x;
        shiftDown(1);
    }

    private void shiftUp(int index){
        while (index > 1 && data[index / 2] < data[index]){
            swap(data,index/2,index);
        }
        index /= 2;
    }

    private void shiftDown(int index){
        while (index * 2 <= size){
            int min = index * 2, right = min + 1;
            if (right <= size && data[right] > data[min]) min++;
            if (data[index] > data[min]){
                swap(data,index,min);
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
