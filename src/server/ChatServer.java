//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private ServerSocket serverSocket;
    private static final List<ClientHandler> clients = new ArrayList();

    public ChatServer() {
    }

    public void startServer() {
        try {
            this.serverSocket = new ServerSocket(5000);
            System.out.println("Server running on port 5000...");

            while(true) {
                Socket var1 = this.serverSocket.accept();
                ClientHandler var2 = new ClientHandler(var1, this);
                clients.add(var2);
                (new Thread(var2)).start();
            }
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    public void broadcast(String var1, ClientHandler var2) {
        for(ClientHandler var4 : clients) {
            if (var4 != var2) {
                var4.sendMessage(var1);
            }
        }

    }

    public static void main(String[] var0) {
        (new ChatServer()).startServer();
    }
}
