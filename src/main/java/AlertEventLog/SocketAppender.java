package AlertEventLog;


import java.net.ServerSocket;
import java.net.Socket;


public interface SocketAppender {

    public static void main(String[] args) throws Exception {

        // 定义端口
        ServerSocket socket = new ServerSocket(4560);
        while (true) {
            Socket client = socket.accept();
            Thread t = new Thread(new LogRunner(client));
            t.start();
        }
    }
}
