//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package client;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
    private int cornerRadius;

    public RoundedPanel(int var1) {
        this.cornerRadius = var1;
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(6, 10, 6, 10));
    }

    protected void paintComponent(Graphics var1) {
        Graphics2D var2 = (Graphics2D)var1;
        var2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        var2.setColor(this.getBackground());
        var2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), this.cornerRadius, this.cornerRadius);
        super.paintComponent(var1);
    }
}
