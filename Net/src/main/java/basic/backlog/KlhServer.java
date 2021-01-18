package basic.backlog;

import basic.timeout.SocketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>2021/1/11 18:02</p>
 *
 * @author konglinghan
 * @version 1.0
 */
public class KlhServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int clientCount = 0;
        ServerSocket serverSocket = new ServerSocket(9999, 5);
        while (true){
            Socket accept = serverSocket.accept();
            System.out.println(accept.isConnected());
//            System.out.println(clientCount);
//            Thread.sleep(2000);
//            accept.getOutputStream().write(1111);
        }
    }
}
