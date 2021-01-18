package basic.backlog;

import java.io.IOException;
import java.net.Socket;

/**
 * <p>2021/1/11 18:07</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class KlhClient {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 30; i++) {
            Socket socket = new Socket("127.0.0.1", 9999);
            System.out.println(socket.getLocalPort());
        }
    }
}
