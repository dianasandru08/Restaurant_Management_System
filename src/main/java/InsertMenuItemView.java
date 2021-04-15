import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InsertMenuItemView extends JFrame {

    private JLabel orderDetailsL;
    private JLabel accountDetailsL;
    private JLabel numeL;
    private JTextField numeTf;
    private JLabel cantitateL;
    private JTextField cantitateTf;
    private JLabel durataL;
    private JTextField durataTf;
    private JLabel pretL;
    private JTextField pretTf;
    private JLabel elementeL;
    private JTextField elementeTf;
    /*
    private JLabel idL;
    private JTextField idTf;
    private JLabel dataL;
    private JTextField dataTf;
    private JLabel oraL;
    private JTextField oraTf;
    private JLabel masaL;
    private JTextField masaTf;

     */
    private JLabel BaseTypeL;
    private JLabel CompositeTypeL;
    private JRadioButton BaseType;
    private JRadioButton CompositeType;
    private ButtonGroup buttonGroup;
    private JButton insertBtn;

    public InsertMenuItemView() {

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
        accountDetailsL = new JLabel("MenuItem details");
        accountDetailsL.setBounds(20, 20, 205, 25);
        accountDetailsL.setHorizontalAlignment(SwingConstants.CENTER);
        accountDetailsL.setForeground(Color.green);
        add(accountDetailsL);
/*
        idL = new JLabel("ID:");
        idL.setBounds(265, 60, 100, 25);
        add(idL);

        idTf = new JTextField();
        idTf.setBounds(105, 60, 100, 25);
        add(idTf);

        dataL = new JLabel("Data:");
        dataL.setBounds(20, 100, 80, 25);
        add(dataL);

        dataTf = new JTextField();
        dataTf.setBounds(105, 100, 100, 25);
        add(dataTf);

        oraL = new JLabel("Ora: ");
        oraL.setBounds(20, 140, 80, 25);
        add(oraL);

        oraTf = new JTextField();
        oraTf.setBounds(105, 140, 100, 25);
        add(oraTf);

        masaL = new JLabel("Masa:");
        masaL.setBounds(20, 180, 80, 25);
        add(masaL);

        masaTf = new JTextField();
        masaTf.setBounds(105, 180, 100, 25);
        add(masaTf);


 */
        numeL = new JLabel("Nume:");
        numeL.setBounds(20, 60, 80, 25);
        add(numeL);

        numeTf = new JTextField();
        numeTf.setBounds(105, 60, 100, 25);
        add(numeTf);

        cantitateL = new JLabel("Cantitate:");
        cantitateL.setBounds(20, 100, 80, 25);
        add(cantitateL);

        cantitateTf = new JTextField();
        cantitateTf.setBounds(105, 100, 100, 25);
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

        elementeL = new JLabel("Compozitie:");
        elementeL.setBounds (265, 60, 100, 25);
        add(elementeL);

        elementeTf =new JTextField();
        elementeTf.setBounds(265, 100, 100, 25);
        add(elementeTf);


        BaseTypeL = new JLabel("Base Product: ");
        BaseTypeL.setBounds(265, 140, 60, 25);
        add(BaseTypeL);

        BaseType = new JRadioButton();
        BaseType.setBounds(315, 140, 20, 25);
        add(BaseType);

        CompositeTypeL = new JLabel("Composite Product: ");
        CompositeTypeL.setBounds(360, 140, 60, 25);
        add(CompositeTypeL);

        CompositeType = new JRadioButton();
        CompositeType.setBounds(430, 140, 20, 25);
        add(CompositeType);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(BaseType);
        buttonGroup.add(CompositeType);

        insertBtn = new JButton("Insert");
        insertBtn.setBounds(265, 180, 185, 25);
        add(insertBtn);



        setVisible(true);
    }
/*
    public Comanda getOrderToInsert() throws IllegalArgumentException {
        int id = Integer.parseInt(idTf.getText());
        int ora= Integer.parseInt(oraTf.getText());
        int masa  = Integer.parseInt(masaTf.getText());
        return new Comanda (id, dataTf.getText(), ora, masa);
    }


 */
    public MenuItem getMenuItemToInsert(ArrayList<MenuItem> meniu) throws IllegalArgumentException {
        if(BaseType.isSelected() == true) {
            int cantitate = Integer.parseInt(cantitateTf.getText());
            int durata = Integer.parseInt(durataTf.getText());
            float pret = Float.parseFloat(pretTf.getText());
            return new BaseProduct(numeTf.getText(), cantitate, durata, pret);
        }
        else {
            ArrayList<MenuItem> con = new ArrayList<MenuItem>();
            String[] produse = elementeTf.getText().split(", ");
            for(MenuItem r: meniu){
                for(String s: produse){
                    if(r instanceof BaseProduct){
                        if(s.equals(r.getNume()) ){
                            con.add(r);
                        }
                    }
                }
            }
            int cantitate = Integer.parseInt(cantitateTf.getText());
            int durata = Integer.parseInt(durataTf.getText());
           return new CompositeProduct(numeTf.getText(), cantitate, durata, con);
        }
    }

    public void addInsertButtonListener(ActionListener e) {
        insertBtn.addActionListener(e);
    }

}
