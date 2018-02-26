package AlertEventLog.util.AlertLog;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketThread extends Thread {

    private ServerSocket serverSocket = null;

    public SocketThread(ServerSocket serverSocket) {
        try {
            if (null == serverSocket) {
                this.serverSocket = new ServerSocket(4560);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                if (null != socket && !socket.isClosed()) {
//                    new SocketOperate(socket).start();
                    Thread clientThread = new Thread(new LogRunner(socket));
                    clientThread.start();
                }
//                socket.setSoTimeout(30000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeSocketServer() {
        if (null != serverSocket && !serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
