package nio;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * @author klhans
 */
public class Test1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(20);
        out(intBuffer);
        for (int i = 1; i < 5; i++) {
            intBuffer.put(i);
        }
        out(intBuffer);

        intBuffer.flip();
        out(intBuffer);

        intBuffer.clear();

        System.out.println(intBuffer.get());
        System.out.println(intBuffer.get(0));
    }

    public static void out(Buffer buffer) {
        System.out.println("capacity:   "+ buffer.capacity());
        System.out.println("limit:   "+ buffer.limit());
        System.out.println("position:   "+ buffer.position());
    }
}
