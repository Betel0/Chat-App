//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private ChatServer server;

    public ClientHandler(Socket var1, ChatServer var2) {
        this.socket = var1;
        this.server = var2;

        try {
            this.reader = new BufferedReader(new InputStreamReader(var1.getInputStream()));
            this.writer = new PrintWriter(var1.getOutputStream(), true);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public void sendMessage(String var1) {
        this.writer.println(var1);
    }

    public void run() {
        String var1;
        try {
            while((var1 = this.reader.readLine()) != null) {
                this.server.broadcast(var1, this);
            }
        } catch (IOException var2) {
            System.out.println("Client disconnected.");
        }

    }
}
