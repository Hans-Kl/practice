package leetcode;

/**
 * 斐波那契数列:0,1,1,2,3,5,8
 * 思路:
 * 根据题干总结出来的 F(n)=F(n-1)+F(n-2),很容易判断出来这是一道考察递归的题目
 * 题解:
 * 斐波那契数列的计算链路就像二叉树一样,每次N的增加都是将树拔高一个位置,多出来一半的分支
 * <p>2020/12/12 14:41</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class S509 {
    //递归,最简单但性能最差,O(2^n),O(n)
    public int fib1(int N) {
//        if (N == 0) return 0;
//        if (N == 1) return 1;
        if (N <= 1) return N;
        return fib1(N - 1) + fib1(N - 2);
    }

    //递归基础上增加一个数组缓存计算过的fib
    //思路没问题,但是写错了,每次迭代都创建了一个数组,以后写完要检查一遍再跑
    @Wrong
    public int fib2(int N) {
        int[] FN = new int[N - 1];
        FN[0] = 0;
        FN[1] = 1;
        if (N < 2) return N;
        if (FN[N] != 0) {
            return FN[N];
        } else {
            int r = fib2(N - 1) + fib2(N - 2);
            FN[N] = r;
            return r;
        }
    }

    //迭代,自底向上缓存数据,O(n)+O(n)
    public int fib3(int N) {
        if (N < 2) return N;
        int[] cache = new int[N + 1];
        cache[1] = 1;

        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[N];
    }

    //递归+缓存,O(n)+O(n)
    public int fib4(int N) {
        int[] cache = new int[N + 1];
        return getFib(N, cache);
    }

    private int getFib(int N, int[] cache){
        if (N < 2) return N;
        if (cache[N] == 0) {
            cache[N] = getFib(N - 1, cache) + getFib(N - 2, cache);
        }
        return cache[N];
    }

    //迭代+缓存两个值,O(n)+O(1)
    public int fib5(int N) {
        // TODO: 2020/12/12
        return 0;
    }


    //Binet公式法,O(1)+O(1)
    public int binet() {
        return 1;
    }




}

