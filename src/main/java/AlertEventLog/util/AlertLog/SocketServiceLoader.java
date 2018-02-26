package AlertEventLog.util.AlertLog;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServiceLoader implements ServletContextListener {

    private SocketThread socketThread = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        if (null == socketThread) {
            socketThread = new SocketThread(null);
            socketThread.start();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (null != socketThread && !socketThread.isInterrupted()) {
            socketThread.closeSocketServer();
            socketThread.interrupt();
        }
    }
}
