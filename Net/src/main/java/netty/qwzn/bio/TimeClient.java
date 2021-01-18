package netty.qwzn.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * <p>2021/1/5 15:29</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TimeClient {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        Socket socket = new Socket("127.0.0.1", port);
        socket.getOutputStream().write(11);
        System.out.println("receive");
        System.out.println(socket.getInputStream());
    }
}
