import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener {

    JButton button;
    JLabel instructions;
    JTextField minutes;

    Frame() {
        JFrame frame = new JFrame("Shutdown");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,170);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setVisible(true);
        frame.setResizable(true);

        instructions = new JLabel("Set minutes to shutdown!");
        instructions.setBounds(20,20,150,20);
        instructions.setForeground(Color.white);

        minutes = new JTextField();
        minutes.setBounds(20,70,100,20);
        minutes.setBackground(Color.gray);
        minutes.setForeground(Color.YELLOW);

        button = new JButton("Start");
        button.setBounds(180, 20 , 80,80);
        button.addActionListener(this);
        button.setBackground(Color.LIGHT_GRAY);

        frame.add(button);
        frame.add(instructions);
        frame.add(minutes);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button) {
            int mins = 0;
            try {
                mins = Integer.parseInt(minutes.getText()) * 60;
            }
            catch (Exception e) {
                minutes.setText("invalid minutes!");
            }
            
            try
            {
                if (mins == 0) {
                    Runtime.getRuntime().exec("cmd /K \"shutdown /a\"");
                } else {
                    Runtime.getRuntime().exec(String.format("cmd /K \"shutdown /s /t %d\"", mins));
                }
            }
            catch (Exception e)
            {
                System.out.println("HEY Buddy ! U r Doing Something Wrong ");
                e.printStackTrace();
            }
        }
    }
}
