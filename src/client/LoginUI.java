//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package client;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LoginUI extends JFrame {
    private JTextField usernameField;
    private JButton loginBtn;

    public LoginUI() {
        this.setTitle("Login");
        this.setSize(400, 350);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.setUndecorated(true);
        this.setShape(new RoundRectangle2D.Double((double)0.0F, (double)0.0F, (double)this.getWidth(), (double)this.getHeight(), (double)50.0F, (double)50.0F));
        JPanel var1 = new JPanel() {
            protected void paintComponent(Graphics var1) {
                Graphics2D var2 = (Graphics2D)var1;
                var2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint var3 = new GradientPaint(0.0F, 0.0F, new Color(0, 150, 136), 0.0F, (float)this.getHeight(), new Color(0, 200, 180));
                var2.setPaint(var3);
                var2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 50, 50);
            }
        };
        var1.setLayout(new GridBagLayout());
        this.add(var1);
        RoundedPanel var2 = new RoundedPanel(30);
        var2.setBackground(new Color(255, 255, 255, 240));
        var2.setLayout(new BoxLayout(var2, 1));
        var2.setOpaque(true);
        var2.setBorder(new EmptyBorder(30, 30, 30, 30));
        var2.setShadow(new Color(0, 0, 0, 40), 5, 5);
        JLabel var3 = new JLabel("ðŸ’¬ ChatApp");
        var3.setFont(new Font("SansSerif", 1, 28));
        var3.setForeground(new Color(0, 150, 136));
        var3.setAlignmentX(0.5F);
        JLabel var4 = new JLabel("Enter Username:");
        var4.setFont(new Font("SansSerif", 1, 16));
        var4.setForeground(Color.DARK_GRAY);
        var4.setAlignmentX(0.5F);
        this.usernameField = new JTextField();
        this.usernameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        this.usernameField.setFont(new Font("SansSerif", 0, 15));
        this.usernameField.setBorder(new RoundedBorder(15));
        this.usernameField.setBackground(new Color(255, 255, 255));
        this.usernameField.setForeground(Color.BLACK);
        this.loginBtn = new JButton("Login") {
            protected void paintComponent(Graphics var1) {
                if (this.getModel().isPressed()) {
                    var1.setColor(new Color(30, 180, 80));
                } else if (this.getModel().isRollover()) {
                    var1.setColor(new Color(50, 230, 120));
                } else {
                    var1.setColor(new Color(37, 211, 102));
                }

                var1.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 20, 20);
                super.paintComponent(var1);
            }

            protected void paintBorder(Graphics var1) {
            }
        };
        this.loginBtn.setFont(new Font("SansSerif", 1, 16));
        this.loginBtn.setForeground(Color.WHITE);
        this.loginBtn.setFocusPainted(false);
        this.loginBtn.setContentAreaFilled(false);
        this.loginBtn.setOpaque(false);
        this.loginBtn.setAlignmentX(0.5F);
        this.loginBtn.addActionListener(this::login);
        var2.add(var3);
        var2.add(Box.createVerticalStrut(20));
        var2.add(var4);
        var2.add(Box.createVerticalStrut(10));
        var2.add(this.usernameField);
        var2.add(Box.createVerticalStrut(20));
        var2.add(this.loginBtn);
        var1.add(var2);
    }

    private void login(ActionEvent var1) {
        String var2 = this.usernameField.getText().trim();
        if (var2.isEmpty()) {
            UIError.showError(this, "Login Failed", "Username cannot be empty!");
        } else {
            try {
                new ChatClient(var2);
                this.dispose();
            } catch (Exception var4) {
                UIError.showError(this, "Connection Error", "Unable to connect to server.\nMake sure the server is running.");
            }

        }
    }

    public static void main(String[] var0) {
        SwingUtilities.invokeLater(() -> (new LoginUI()).setVisible(true));
    }

    static class RoundedBorder extends LineBorder {
        private int radius;

        RoundedBorder(int var1) {
            super(Color.GRAY, 2, true);
            this.radius = var1;
        }

        public void paintBorder(Component var1, Graphics var2, int var3, int var4, int var5, int var6) {
            Graphics2D var7 = (Graphics2D)var2;
            var7.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            var7.setColor(this.lineColor);
            var7.setStroke(new BasicStroke((float)this.thickness));
            var7.drawRoundRect(var3, var4, var5 - 1, var6 - 1, this.radius, this.radius);
        }
    }

    static class RoundedPanel extends JPanel {
        private int cornerRadius;
        private Color shadowColor;
        private int shadowX;
        private int shadowY;

        public RoundedPanel(int var1) {
            this.cornerRadius = var1;
            this.setOpaque(false);
        }

        public void setShadow(Color var1, int var2, int var3) {
            this.shadowColor = var1;
            this.shadowX = var2;
            this.shadowY = var3;
        }

        protected void paintComponent(Graphics var1) {
            Graphics2D var2 = (Graphics2D)var1;
            var2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (this.shadowColor != null) {
                var2.setColor(this.shadowColor);
                var2.fillRoundRect(this.shadowX, this.shadowY, this.getWidth(), this.getHeight(), this.cornerRadius, this.cornerRadius);
            }

            var2.setColor(this.getBackground());
            var2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), this.cornerRadius, this.cornerRadius);
            super.paintComponent(var1);
        }
    }
}
