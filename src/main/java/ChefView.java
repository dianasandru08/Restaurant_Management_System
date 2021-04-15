import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class ChefView extends JFrame {
    private JTable table;
    private JScrollPane tableHolder;
    private JTextField message;



    public ChefView() {

        setTitle("CHEF View");
        setBounds(520, 100, 615, 340);
        setLayout(null);


        message = new JTextField();
        message.setBounds(30, 250, 550, 30);
        add(message);

        setVisible(true);
    }

    public void set(String s){
        message.setText(s);
    }

    public void addRow(MenuItem p) {
        String[] row = new String[]{((Integer)(table.getRowCount() + 1)).toString(), p.getNume()+""};
        TableModel tM = table.getModel();
        ((DefaultTableModel)tM).addRow(row);
        table.setModel(tM);
    }

    public void createTable(ArrayList<MenuItem> m) {

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("NUME");

        // tableModel.addColumn("Compozitie");
        int i = 1;
        for(MenuItem p : m) {
            String[] oneRow = new String[6];
            oneRow[0] = i + "";
            oneRow[1] = p.getNume();
            i++;
            //oneRow[5]= p.getPret() + " " + p.getCantitate();
            //System.out.println(oneRow[5]);
            tableModel.addRow(oneRow);
        }

        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        //table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.setFillsViewportHeight(true);
        tableHolder = new JScrollPane(table);
        tableHolder.setBounds(10, 10, 580, 220);
        add(tableHolder);
    }



/*


    public void addCreateButtonListener(ActionListener e) {
        createBtn.addActionListener(e);
    }

    public void addPriceButtonListener(ActionListener e) {
        priceBtn.addActionListener(e);
    }

    public void addBillButtonListener(ActionListener e) {
        billBtn.addActionListener(e);
    }

    public void addShowButtonListener(ActionListener e) {
        showBtn.addActionListener(e);
    }

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

 */

}
