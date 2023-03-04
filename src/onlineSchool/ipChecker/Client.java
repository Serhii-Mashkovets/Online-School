package onlineSchool.ipChecker;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static onlineSchool.ipChecker.Server.PORT;

public class Client implements Runnable {

    @Override
    public void run() {
        try (Socket socket = new Socket("192.172.1.10", PORT); Scanner console = new Scanner(System.in);
             Scanner in = new Scanner(socket.getInputStream());
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String toServer = " ";
            String access = in.nextLine();
            System.out.println(access);
            if (access.equals("Welcome")) {
                System.out.println("Введіть \"Вихід\" щоб завершити сесію. Введіть повідомлення:");
                while (true) {
                    toServer = console.nextLine();
                    out.println(toServer);
                    if (toServer.equals("Вихід")) break;
                    System.out.println("Інформаія серверу: " + in.nextLine());
                }
            }
            out.println(toServer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Вихід.");
        }
    }

}
