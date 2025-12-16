//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package client;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class UIError {
    public UIError() {
    }

    public static void showError(Component var0, String var1, String var2) {
        UIManager.put("OptionPane.messageFont", new Font("SansSerif", 0, 14));
        UIManager.put("OptionPane.buttonFont", new Font("SansSerif", 1, 13));
        JOptionPane.showMessageDialog(var0, var2, var1, 0);
    }

    public static void showInfo(Component var0, String var1, String var2) {
        UIManager.put("OptionPane.messageFont", new Font("SansSerif", 0, 14));
        UIManager.put("OptionPane.buttonFont", new Font("SansSerif", 1, 13));
        JOptionPane.showMessageDialog(var0, var2, var1, 1);
    }
}
