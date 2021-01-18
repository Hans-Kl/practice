package netty.qwzn.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>2021/1/4 20:49</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket server = new ServerSocket(port);
        System.out.println("server start");
        Socket socket = null;
        while (true) {
            socket = server.accept();//没收到客户端请求时阻塞,收到请求时包装为socket并解除阻塞
            InputStream inputStream = socket.getInputStream();//拿到客户端发送的输入流
            System.out.println(inputStream);
            socket.getOutputStream().write(222);//返回给客户端
            System.out.println(socket.isConnected());
        }
    }
}
