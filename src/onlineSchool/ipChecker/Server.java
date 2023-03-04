package onlineSchool.ipChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    public static final int PORT = 5000;
    private static String blackList;

    private static String blacklistPath;

    public static String readBlackList() {
        setBlacklistPath("src/onlineSchool/ipChecker/BlackList.txt");
        Path path = Path.of(getBlacklistPath());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String ip;
            while ((ip = br.readLine()) != null) {
                builder.append(ip);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return builder.toString();
    }

    public Server() {
        blackList = readBlackList();
    }


    @Override
    public void run() {
        Thread watcher = new Thread(new BlackListChecker(), "blackListChecker");
        watcher.start();
        ExecutorService ex = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущено з порту: " + PORT);

            while (!server.isClosed()) {
                Socket socket = server.accept();
                if (blackList.contains(socket.getInetAddress().getHostAddress())) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    System.out.println("Клієнту відмовлено тому, що IP адреса " +
                            socket.getInetAddress().getHostAddress() + " в чорному списку.");
                    out.println("IP in blacklist.");
                    socket.close();
                } else ex.execute(new MyTask(socket));
            }
            ex.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            watcher.interrupt();
            System.out.println("Сервер зачинено.");
        }
    }

    static class MyTask implements Runnable {
        Socket client;

        public MyTask(Socket socket) {
            this.client = socket;
        }

        @Override
        public void run() {
            try (Scanner in = new Scanner(client.getInputStream());
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                out.println("Welcome");
                String fromClient;

                while (!(fromClient = in.nextLine()).equals("Вихід")) {
                    out.println("Рядок як масив байт - " + Arrays.toString(fromClient.getBytes()));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    client.close();
                    System.out.println("Сесію клієнта завершено.");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static String getBlackList() {
        return blackList;
    }

    public static void setBlackList(String blackList) {
        Server.blackList = blackList;
    }

    public static String getBlacklistPath() {
        return blacklistPath;
    }

    public static void setBlacklistPath(String blacklistPath) {
        Server.blacklistPath = blacklistPath;
    }

}
