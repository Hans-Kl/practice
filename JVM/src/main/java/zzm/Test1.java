package zzm;

import org.openjdk.jol.vm.VM;

/**
 * <p>2020/11/24 下午4:47</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class Test1 {
    public static int b;

    public static void main(String[] args) {
        int a;
        System.out.println(a = 1);
        System.out.println("b" + b);

        String[] arr=new String[1];
        System.out.println(arr[1]);
        System.out.println(arr[0]);


    }
}
