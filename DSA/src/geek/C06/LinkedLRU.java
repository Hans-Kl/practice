package geek.C06;

/**
 * 用链表实现LRU算法
 * LRU是一种缓存淘汰算法,常见的缓存淘汰算法有三种:
 * 1. FIFO 先进先出
 * 2. LFU Least Frequently Used 按被使用的频率大小排序
 * 3. LRU Least Recently Used 使用一次就移到最顶部,淘汰的时候淘汰最底部的缓存.一般使用链表实现
 *
 * <p>
 *     https://www.cnblogs.com/hongdada/p/10406902.html
 * </p>
 * <p>2020/12/22 10:48</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class LinkedLRU {

    private Node node;

    public Node get(String k) {
        Node x = node;//遍历链表需要一个指针指向当前元素
        while (x != null) {
            if (k == x.key) return x;
            x = x.next;
        }
        return null;
    }

    public void set(String k) {

    }

    private class Node {
        Node next;
        String key;
        String value;
    }
}
