package basic.timeout;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>2021/1/7 17:24</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
//        serverSocket.setSoTimeout(2000);//accpet只会等待一段时间,过期就抛超时异常
        while (true){
            Socket accept = serverSocket.accept();
            System.out.println(accept.isConnected());
            System.out.println(accept.isClosed());
        }
    }
}
