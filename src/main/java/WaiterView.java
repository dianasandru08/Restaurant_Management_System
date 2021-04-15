import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class WaiterView extends JFrame {
    private JTable table;
    private JScrollPane tableHolder;
    private JButton createBtn;
    private JButton priceBtn;
    private JButton billBtn;
    private JTextField pBtn;

    public WaiterView() {

        setTitle("Waiter View");
        setBounds(520, 100, 615, 340);
        setLayout(null);

        createBtn = new JButton("Create");
        createBtn.setBounds(30, 250, 100, 30);
        add(createBtn);

        priceBtn = new JButton("Price");
        priceBtn.setBounds(175, 250, 100, 30);
        add(priceBtn);

        billBtn = new JButton("Bill");
        billBtn.setBounds(325, 250, 100, 30);
        add(billBtn);

        pBtn = new JTextField();
        pBtn.setBounds(470, 250, 100, 30);
        add(pBtn);

        setVisible(true);
    }

    public void createTable(Set<Comanda> comenzi) {

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Data");
        tableModel.addColumn("Ora");
        tableModel.addColumn("Masa");
        // tableModel.addColumn("Compozitie");

        for(Comanda p : comenzi) {
            String[] oneRow = new String[6];
            oneRow[0] = p.getId() + "";
            oneRow[1] = p.getData();
            oneRow[2] = p.getOra()+ "" ;
            oneRow[3] = p.getMasa()+"";
            //oneRow[5]= p.getPret() + " " + p.getCantitate();
            //System.out.println(oneRow[5]);
            tableModel.addRow(oneRow);
        }

        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.setFillsViewportHeight(true);
        tableHolder = new JScrollPane(table);
        tableHolder.setBounds(10, 10, 580, 220);
        add(tableHolder);


    }






    public void addCreateButtonListener(ActionListener e) {
        createBtn.addActionListener(e);
    }

    public void addPriceButtonListener(ActionListener e) {
        priceBtn.addActionListener(e);
    }

    public void addBillButtonListener(ActionListener e) {
        billBtn.addActionListener(e);
    }

    //public void addShowButtonListener(ActionListener e) {
        //showBtn.addActionListener(e);
    //}

    public void addRow(Comanda p) {
        String[] row = new String[]{p.getId() + "", p.getData() + "", p.getOra()+"", p.getMasa()+""};
        TableModel tM = table.getModel();
        ((DefaultTableModel)tM).addRow(row);
        table.setModel(tM);
    }

    public void Update(String cantitate, String durata, String pret) {
        // createTable(menus);
        DefaultTableModel tM =  (DefaultTableModel) table.getModel();
        //((DefaultTableModel)tM).fireTableDataChanged();
        int selectedRowIndex = table.getSelectedRow();
        tM.setValueAt(cantitate, selectedRowIndex, 2);
        tM.setValueAt(durata, selectedRowIndex, 3);
        tM.setValueAt(pret, selectedRowIndex, 4);

    }

    public void setP (float pret){
        pBtn.setText(Float.toString(pret));
    }
    public Comanda getSelectedOrder() {
        int selectedRow = table.getSelectedRow();
        TableModel tableModel = table.getModel();
        int idOrder = Integer.parseInt((String)tableModel.getValueAt(selectedRow, 0));
        String dataOrder = (String)tableModel.getValueAt(selectedRow, 1);
        int ora = Integer.parseInt((String)tableModel.getValueAt(selectedRow, 2));
        int masa=Integer.parseInt((String)tableModel.getValueAt(selectedRow, 3));
        return new Comanda(idOrder, dataOrder, ora, masa);
    }
    public void deleteSelectedRow() {
        TableModel tM = table.getModel();
        ((DefaultTableModel)tM).removeRow(table.getSelectedRow());
        table.setModel(tM);
    }

}
