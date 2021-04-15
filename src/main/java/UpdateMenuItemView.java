import javax.swing.*;
import java.awt.event.ActionListener;

public class UpdateMenuItemView extends JFrame {
    private JLabel cantitateL;
    private JTextField cantitateTf;
    private JLabel durataL;
    private JTextField durataTf;
    private JLabel pretL;
    private JTextField pretTf;
    private JButton execute;

    public UpdateMenuItemView(){
        setTitle("Update Menu Item");
        setBounds(520, 100, 490, 265);
        setLayout(null);

        cantitateL = new JLabel("Cantitate:");
        cantitateL.setBounds(20, 60, 80, 25);
        add(cantitateL);

        cantitateTf= new JTextField();
        cantitateTf.setBounds(105, 60, 100, 25);
        add(cantitateTf);

        durataL = new JLabel("Durata:");
        durataL.setBounds(20, 140, 80, 25);
        add(durataL);

        durataTf = new JTextField();
        durataTf.setBounds(105, 140, 100, 25);
        add(durataTf);

        pretL = new JLabel("Pret:");
        pretL.setBounds(20, 180, 80, 25 );
        add(pretL);

        pretTf = new JTextField();
        pretTf.setBounds(105, 180, 100, 25);
        add(pretTf);

        execute = new JButton("Update");
        execute.setBounds(265, 180, 185, 25);
        add(execute);
        setVisible(true);
    }
    public int getCantitateUpdate()
    {
        int cantitate;
        String cantitateS = cantitateTf.getText();
        if(cantitateS.equals("") ){
            cantitate = -1;
        }
        else
            cantitate = Integer.parseInt(cantitateS);
        return cantitate;
    }
    public int getDurataUpdate()
    {
        int durata;
        String durataS = durataTf.getText();
        if(durataS.equals("")){
            durata = -1;
        }
        else
            durata = Integer.parseInt(durataS);
        return durata;
    }
    public float getPretUpdate()
    {   float pret;
        String pretS = pretTf.getText();
        if(pretS.equals("")){
            pret = -1;
        }
        else
            pret = Float.parseFloat(pretS);
        return pret;
    }
    public void addUpdateButtonListener(ActionListener e) {
        execute.addActionListener(e);
    }
}
