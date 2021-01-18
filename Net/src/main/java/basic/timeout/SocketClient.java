package basic.timeout;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * <p>2021/1/7 17:29</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(8888),1000);//客户端connect超时
        socket.setSoTimeout(2000);//客户端socket超时,即等待服务端返回(read读)超时
        socket.getOutputStream().write(1111);
        InputStream inputStream = socket.getInputStream();
        System.out.println(inputStream);
        System.out.println(inputStream.read());
        System.out.println(socket.isConnected());
        System.out.println(socket.isClosed());
    }
}
