package Server;

import Server.IServerStrategy;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private volatile boolean stop;
    private ExecutorService threadPool; // Thread pool


    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
        // initialize a new fixed thread pool with 2 threads:
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("C:\\Users\\liron\\IdeaProjects\\ATP-Project-PartB\\resources\\config.properties")) {
            prop.load(input);
            this.threadPool = Executors.newFixedThreadPool(Integer.parseInt(prop.getProperty("threadPoolSize")));
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(listeningIntervalMS);
           // LOG.info("Starting server at port = " + port);

            while (!stop) {
                try {
                    Socket clientSocket = serverSocket.accept();
               //     LOG.info("Client accepted: " + clientSocket.toString());

                    // Insert the new task into the thread pool:
                    threadPool.submit(() -> {
                        handleClient(clientSocket);
                    });

                    // From previous lab:
                    // This thread will handle the new Client
                    //new Thread(() -> {
                    //    handleClient(clientSocket);
                    //}).start();

                } catch (SocketTimeoutException e){
             //       LOG.debug("Socket timeout");
                }
            }
            serverSocket.close();
            //threadPool.shutdown(); // do not allow any new tasks into the thread pool (not doing anything to the current tasks and running threads)
            threadPool.shutdownNow(); // do not allow any new tasks into the thread pool, and also interrupts all running threads (do not terminate the threads, so if they do not handle interrupts properly, they could never stop...)
        } catch (IOException e) {
         //   LOG.error("IOException", e);
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            strategy.applyStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
          //  LOG.info("Done handling client: " + clientSocket.toString());
            clientSocket.close();
        } catch (IOException e){
          //  LOG.error("IOException", e);
        }
    }

    public void stop(){
      //  LOG.info("Stopping server...");
        stop = true;
    }
}
