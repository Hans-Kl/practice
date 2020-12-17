package leetcode;

/**
 * <p>2020/12/2 23:40</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class S905 {
    public static int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int ou = 0;
        int ji = A.length - 1;
        for (int a : A) {
            if (a % 2 == 0) {
                B[ou] = a;
                ou++;
            } else {
                B[ji] = a;
                ji--;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] ints = sortArrayByParity(new int[]{3, 1, 2, 4});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
