import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sudokuApp {
    public static int[][] sudoku = {
            {0,0,1,9,8,4,7,6,0},
            {6,0,0,0,5,7,0,0,0},
            {8,0,7,0,1,0,0,0,0},
            {9,6,0,3,0,8,1,0,5},
            {1,8,5,0,2,0,0,7,3},
            {3,0,0,0,0,0,2,0,8},
            {2,1,0,0,0,0,0,3,6},
            {0,0,0,1,0,0,0,0,4},
            {0,9,6,0,0,2,5,1,0}};
    public static JButton solveButton = new JButton("Solve");
    public static JFrame frame = new JFrame("sudokuApp");
    public static JPanel panOuter = new JPanel(new BorderLayout());
    public static JPanel panTop = new JPanel(new BorderLayout());
    public static JPanel panBottom = new JPanel();

    public static void main(String[] args) {
        solveButton.addActionListener(new CustomActionListener());
        solveButton.setSize(150,50);
        solveButton.setForeground(Color.BLACK);
        solveButton.setBackground(Color.WHITE);
        solveButton.setFocusPainted(false);
        
        GUI.build(sudoku, frame, panTop);
        panOuter.add(panTop, BorderLayout.NORTH);
        panOuter.add(panBottom, BorderLayout.SOUTH);
        panBottom.add(solveButton);

        frame.setContentPane(panOuter);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    static class CustomActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            solveButton.setText("Puzzle solved");
            sudokuSolver.solve(sudoku);
            GUI.build(sudoku, frame, panTop);
        }
    }
}
