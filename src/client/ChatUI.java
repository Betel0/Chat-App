//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ChatUI extends JFrame {
    private JPanel chatPanel;
    private JScrollPane scrollPane;
    private JTextField messageField;
    private JButton sendButton;
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private String username;
    private MessageListener listener;

    public ChatUI(String var1, MessageListener var2) {
        this.username = var1;
        this.listener = var2;
        this.setTitle("Chat â€“ " + var1);
        this.setSize(480, 700);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
        this.addTopBar();
        this.addChatArea();
        this.addInputBar();
    }

    private void addTopBar() {
        JPanel var1 = new JPanel(new BorderLayout());
        var1.setBackground(new Color(7, 94, 84));
        var1.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel var2 = new JLabel(this.username);
        var2.setFont(new Font("SansSerif", 1, 16));
        var2.setForeground(Color.WHITE);
        JLabel var3 = new JLabel("Online");
        var3.setFont(new Font("SansSerif", 0, 12));
        var3.setForeground(new Color(180, 255, 180));
        JPanel var4 = new JPanel();
        var4.setLayout(new BoxLayout(var4, 1));
        var4.setOpaque(false);
        var4.add(var2);
        var4.add(var3);
        var1.add(var4, "West");
        this.add(var1, "North");
    }

    private void addChatArea() {
        this.chatPanel = new JPanel();
        this.chatPanel.setLayout(new BoxLayout(this.chatPanel, 1));
        this.chatPanel.setBackground(new Color(230, 230, 230));
        this.scrollPane = new JScrollPane(this.chatPanel);
        this.scrollPane.setBorder((Border)null);
        this.scrollPane.getVerticalScrollBar().setUnitIncrement(18);
        this.add(this.scrollPane, "Center");
    }

    private void addInputBar() {
        this.messageField = new JTextField();
        this.messageField.setFont(new Font("SansSerif", 0, 15));
        this.messageField.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.sendButton = new JButton("Send");
        this.sendButton.setBackground(new Color(0, 150, 136));
        this.sendButton.setForeground(Color.WHITE);
        this.sendButton.setFont(new Font("SansSerif", 1, 14));
        this.sendButton.setFocusPainted(false);
        JPanel var1 = new JPanel(new BorderLayout(8, 8));
        var1.setBorder(new EmptyBorder(8, 8, 8, 8));
        var1.add(this.messageField, "Center");
        var1.add(this.sendButton, "East");
        this.add(var1, "South");
        this.sendButton.addActionListener((var1x) -> this.sendMessage());
        this.messageField.addActionListener((var1x) -> this.sendMessage());
    }

    private void sendMessage() {
        String var1 = this.messageField.getText().trim();
        if (var1.isEmpty()) {
            UIError.showError(this, "Empty Message", "You cannot send an empty message.");
        } else {
            try {
                this.listener.onSend(var1);
                this.messageField.setText("");
            } catch (Exception var3) {
                UIError.showError(this, "Send Error", "Could not send your message.");
            }

        }
    }

    public void receiveMessage(String var1, String var2, boolean var3) {
        JPanel var4 = MessageBubble.create(var1, var2, var3);
        this.chatPanel.add(var4);
        this.chatPanel.revalidate();
        this.chatPanel.repaint();
        this.scrollToBottom();
    }

    private void scrollToBottom() {
        SwingUtilities.invokeLater(() -> {
            JScrollBar var1 = this.scrollPane.getVerticalScrollBar();
            var1.setValue(var1.getMaximum());
        });
    }

    public interface MessageListener {
        void onSend(String var1);
    }
}
