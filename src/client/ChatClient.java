//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package client;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private ChatUI ui;
    private String username;

    public ChatClient(String var1) throws Exception {
        this.username = var1;

        try {
            this.socket = new Socket("localhost", 5000);
        } catch (IOException var4) {
            throw new Exception("Could not reach the server.");
        }

        try {
            this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.writer = new PrintWriter(this.socket.getOutputStream(), true);
            this.ui = new ChatUI(var1, this::sendMessage);
            this.ui.setVisible(true);
            this.listenForMessages();
        } catch (IOException var3) {
            UIError.showError((Component)null, "Startup Error", "A problem occurred while connecting to the chat.");
            throw var3;
        }
    }

    public void sendMessage(String var1) {
        try {
            this.writer.println(this.username + "|" + var1);
            this.ui.receiveMessage(this.username, var1, true);
        } catch (Exception var3) {
            UIError.showError(this.ui, "Send Failed", "Message could not be sent.");
        }

    }

    private void listenForMessages() {
        (new Thread(() -> {
            try {
                while(true) {
                    String var1;
                    if ((var1 = this.reader.readLine()) != null) {
                        String[] var2 = var1.split("\\|", 2);
                        if (var2.length >= 2) {
                            String var3 = var2[0];
                            String var4 = var2[1];
                            boolean var5 = var3.equals(this.username);
                            this.ui.receiveMessage(var3, var4, var5);
                        }
                    } else {
                        UIError.showError(this.ui, "Disconnected", "Connection to the server has been lost.");
                        break;
                    }
                }
            } catch (IOException var6) {
                UIError.showError(this.ui, "Connection Error", "You have been disconnected from the server.");
            }

        })).start();
    }
}
