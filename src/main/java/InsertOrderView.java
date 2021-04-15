import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InsertOrderView extends JFrame {
    private JLabel orderDetailsL;
    private JLabel idOrderL;
    private JTextField idOrderTf;
    private JLabel dataL;
    private JTextField dataTf;
    private JLabel oraL;
    private JTextField oraTf;
    private JLabel masaL;
    private JTextField masaTf;
    private JLabel comandateL;
    private JTextField comandateTf;
    //private JLabel elementeL;
    //private JTextField elementeTf;
    private JButton createBtn;

    public InsertOrderView() {

        setTitle("Insert Order");
        setBounds(520, 100, 490, 265);
        setLayout(null);
    /*
        orderDetailsL = new JLabel("Order details");
        orderDetailsL.setBounds(265, 20, 205, 25);
        orderDetailsL.setHorizontalAlignment(SwingConstants.CENTER);
        orderDetailsL.setForeground(Color.green);
        add(orderDetailsL);


     */
        orderDetailsL = new JLabel("MenuItem details");
        orderDetailsL.setBounds(20, 20, 205, 25);
        orderDetailsL.setHorizontalAlignment(SwingConstants.CENTER);
        orderDetailsL.setForeground(Color.green);
        add(orderDetailsL);

        idOrderL = new JLabel("Numarul comenzii:");
        idOrderL.setBounds(20, 60, 80, 25);
        add(idOrderL);

        idOrderTf = new JTextField();
        idOrderTf.setBounds(105, 60, 100, 25);
        add(idOrderTf);

        dataL = new JLabel("Data:");
        dataL.setBounds(20, 100, 80, 25);
        add( dataL);

        dataTf = new JTextField();
        dataTf.setBounds(105, 100, 100, 25);
        add( dataTf);

        oraL = new JLabel("Ora:");
        oraL.setBounds(20, 140, 80, 25);
        add(oraL);

        oraTf = new JTextField();
        oraTf.setBounds(105, 140, 100, 25);
        add(oraTf);

        masaL = new JLabel("Masa:");
        masaL.setBounds(20, 180, 80, 25 );
        add(masaL);

        masaTf = new JTextField();
        masaTf.setBounds(105, 180, 100, 25);
        add(masaTf);

        comandateL = new JLabel("Comanda:");
        comandateL.setBounds (265, 60, 100, 25);
        add( comandateL);

        comandateTf =new JTextField();
        comandateTf.setBounds(265, 100, 100, 25);
        add( comandateTf);

        createBtn = new JButton("Create:");
        createBtn.setBounds(265, 180, 185, 25);
        add(createBtn);
       setVisible(true);
    }
    public Comanda getOrdertoCreate(){
        int id = Integer.parseInt(idOrderTf.getText());
        String data = dataTf.getText();
        int ora = Integer.parseInt(oraTf.getText());
        int masa = Integer.parseInt(masaTf.getText());
        return new Comanda(id, data, ora, masa);
    }
    public ArrayList<MenuItem> getProdComandate(ArrayList<MenuItem> menu){
        ArrayList<MenuItem > prod = new ArrayList<MenuItem>();
        String s = comandateTf.getText();
        String[] parts = s.split(", ");
        //stem.out.println("Ma aflu in Jtextfield care gaseste prd comandate:");
        for(MenuItem m: menu){
            System.out.println(m);
            for(String i: parts){
                System.out.println(i);
                if(i.equals(m.getNume())){
                    System.out.println("Ajung aici");
                    prod.add(m);
                }
            }
        }
        return prod;
    }

    public void addCreateButtonListener(ActionListener e) {
        createBtn.addActionListener(e);
    }
    }
