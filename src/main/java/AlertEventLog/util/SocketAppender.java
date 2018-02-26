package AlertEventLog.util;


import AlertEventLog.util.AlertLog.LogRunner;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 定义SocketAppender输出流
 */
public class SocketAppender {

    public static void main(String[] args) throws Exception {
        System.out.println("service is running...");
        // 定义端口
        ServerSocket socket = new ServerSocket(4560);
        while (true) {
            Socket client = socket.accept();
            Thread t = new Thread(new LogRunner(client));
            t.start();
        }
    }
}
