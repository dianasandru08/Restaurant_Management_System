import javax.swing.*;
import java.awt.event.ActionListener;

public class StartView extends JFrame {
    private JButton waiterBtn;
    private JButton administratorBtn;
    private JButton chefBtn;
    public StartView() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Restaurant management system");
        setBounds(100, 100, 410, 320);
        setLayout(null);

        waiterBtn = new JButton("WAITER");
        waiterBtn.setBounds(80, 40, 235, 80);
        add(waiterBtn);

        administratorBtn = new JButton("ADMINISTRATOR");
        administratorBtn.setBounds(80, 160, 235, 80);
        add(administratorBtn);

        chefBtn = new JButton("CHEF");
        chefBtn.setBounds(80, 130, 235, 20);
        add(chefBtn);

        setVisible(true);
    }

    public void addWaiterButtonActionListener(ActionListener e) {
        waiterBtn.addActionListener(e);
    }
    public void addChefButtonActionListener(ActionListener e) {
        chefBtn.addActionListener(e);
    }

    public void addAdministratorButtonActionListener(ActionListener e) {
        administratorBtn.addActionListener(e);
    }
}
