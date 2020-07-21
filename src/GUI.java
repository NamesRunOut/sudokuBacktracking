import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI{
    public static void build(int[][] a, JFrame frame, JPanel panTop){
        JPanel panel = new JPanel(new GridLayout(9,9));
        panel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        final int borderWidth = 1;
        final int rows = 9;
        final int cols = 9;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                final JLabel label = new JLabel("<html><div style='font-style: calibri;font-size:16pt;color: black;font-weight: 500;'>" + Integer.toString(a[row][col]) + "</div></html>");
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setPreferredSize(new Dimension(30, 30));
                if (row == 0) {
                    if (col == 0) {
                        label.setBorder(BorderFactory.createMatteBorder(borderWidth,
                                borderWidth,
                                borderWidth,
                                borderWidth,
                                Color.BLACK));
                    }
                    else {
                        label.setBorder(BorderFactory.createMatteBorder(borderWidth,
                                0,
                                borderWidth,
                                borderWidth,
                                Color.BLACK));
                    }
                }
                else {
                    if (col == 0) {
                        label.setBorder(BorderFactory.createMatteBorder(0,
                                borderWidth,
                                borderWidth,
                                borderWidth,
                                Color.BLACK));
                    }
                    else {
                        label.setBorder(BorderFactory.createMatteBorder(0,
                                0,
                                borderWidth,
                                borderWidth,
                                Color.BLACK));
                    }
                }
                panel.add(label);
            }
        }
        panTop.add(panel, BorderLayout.NORTH);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
    }
}
