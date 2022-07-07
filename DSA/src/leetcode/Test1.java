import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occ = new HashMap<>();
        for (int num : nums){
            occ.put(num, occ.getOrDefault(num,0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> maxQueue = new PriorityQueue<Map.Entry<Integer, Integer>>(k, entry -> (int) entry.getValue());

        int i = 0;
        for (Map.Entry entry : occ.entrySet()){
            if (i < k) {
                maxQueue.offer(entry);
            } else {
                if (entry.getValue() > maxQueue.peek().getValue()){
                    maxQueue.poll();
                    maxQueue.offer(entry);
                }
            }
            i++;
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = maxQueue.poll().getKey();
        }
        return res;
    }
}