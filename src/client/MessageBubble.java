//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MessageBubble {
    private static final int MAX_WIDTH = 220;
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");

    public MessageBubble() {
    }

    public static JPanel create(String var0, String var1, boolean var2) {
        JPanel var3 = new JPanel(new FlowLayout(var2 ? 2 : 0, 8, 4));
        var3.setOpaque(false);
        var3.setAlignmentX(0.0F);
        RoundedPanel var4 = new RoundedPanel(18);
        var4.setLayout(new BoxLayout(var4, 1));
        var4.setBorder(new EmptyBorder(4, 8, 4, 8));
        if (var2) {
            var0 = "";
        }

        JLabel var5 = new JLabel(var0);
        var5.setFont(new Font("Arial", 1, 10));
        var5.setAlignmentX(0.0F);
        JTextArea var6 = new JTextArea(var1);
        var6.setFont(new Font("Arial", 0, 15));
        var6.setLineWrap(true);
        var6.setWrapStyleWord(true);
        var6.setEditable(false);
        var6.setOpaque(false);
        var6.setBorder((Border)null);
        var6.setColumns(18);
        var6.setAlignmentX(0.0F);
        JLabel var7 = new JLabel(TIME_FORMAT.format(new Date()));
        var7.setFont(new Font("Arial", 0, 9));
        var7.setAlignmentX(var2 ? 1.0F : 0.0F);
        if (var2) {
            var4.setBackground(new Color(37, 211, 102));
            var5.setForeground(Color.WHITE);
            var6.setForeground(Color.WHITE);
            var7.setForeground(new Color(220, 255, 220));
        } else {
            var4.setBackground(new Color(192, 192, 192));
            var5.setForeground(Color.BLACK);
            var6.setForeground(Color.BLACK);
            var7.setForeground(Color.GRAY);
        }

        var4.add(var5);
        var4.add(Box.createVerticalStrut(2));
        var4.add(var6);
        var4.add(Box.createVerticalStrut(2));
        var4.add(var7);
        Dimension var8 = var4.getPreferredSize();
        var4.setMaximumSize(var8);
        var3.add(var4);
        return var3;
    }
}
